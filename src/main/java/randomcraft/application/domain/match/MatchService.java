package randomcraft.application.domain.match;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.ability.AbilityRepository;
import randomcraft.application.domain.match.dto.MatchCreateDto;
import randomcraft.application.domain.match.dto.MatchResponseDto;
import randomcraft.application.domain.match.dto.MatchStatusUpdateDto;
import randomcraft.application.domain.match.dto.MatchUpdateDto;
import randomcraft.application.domain.player.Player;
import randomcraft.application.domain.player.PlayerRepository;
import randomcraft.application.exception.BadRequestException;
import randomcraft.application.util.response.PaginationResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchDataRepository matchDataRepository;
    private final MatchRepository matchRepository;
    private final AbilityRepository abilityRepository;
    private final PlayerRepository playerRepository;

    @Transactional
    public MatchResponseDto updateMatch(MatchUpdateDto matchUpdateDto) {

        Match match = matchRepository.findById(matchUpdateDto.getId())
                .orElseThrow(() ->
                        new BadRequestException(String.format("Match with id %s not found.", matchUpdateDto.getId())));

        List<MatchData> matchDataList = matchUpdateDto.getMatchItems().stream()
                .map(matchDataUpdateDto -> {
                    Ability ability = abilityRepository.findById(matchDataUpdateDto.getAbilityId())
                            .orElseThrow(() -> new BadRequestException("No ability by id " + matchDataUpdateDto.getAbilityId()));
                    Player player = playerRepository.findById(matchDataUpdateDto.getPlayerId())
                            .orElseThrow(() -> new BadRequestException("No player by id " + matchDataUpdateDto.getPlayerId()));

                    return MatchData.create(matchDataUpdateDto.getLocation(), matchDataUpdateDto.getRace(),
                            matchDataUpdateDto.getResult(), ability, player);
                }).toList();


        match.updateMatchInfo(
                matchUpdateDto.getPlayedOn(), matchUpdateDto.getSummary(), matchUpdateDto.getBestOf(),
                matchUpdateDto.getGameNumber(), matchUpdateDto.getVods(), matchDataList
        );

        return new MatchResponseDto(match);
    }


    public MatchResponseDto getMatchById(Long matchId) {
        Match match = findById(matchId);
        return new MatchResponseDto(match);
    }

    @Transactional
    public MatchResponseDto updateMatchStatus(MatchStatusUpdateDto statusUpdateDto) {
        Match match = findById(statusUpdateDto.getMatchId());
        switch (statusUpdateDto.getStatus()) {
            case APPROVED -> match.approveMatch();
            case REJECTED -> match.rejectMatch();
            default -> match.restoreStatusDefault();
        }
        return new MatchResponseDto(match);
    }

    @Transactional
    public MatchResponseDto createMatch(MatchCreateDto matchCreateDto) {

        List<MatchData> matchDataList = matchCreateDto.getMatchItems().stream()
                .map(item -> {
                    Ability ability = abilityRepository.findById(item.getAbilityId())
                            .orElseThrow(() -> new BadRequestException("No ability by id " + item.getAbilityId()));

                    Player player = playerRepository.findById(item.getPlayerId())
                            .orElseThrow(() -> new BadRequestException("No player by id " + item.getPlayerId()));

                    return MatchData.create(
                            item.getLocation(), item.getRace(), item.getResult(), ability, player
                    );
                })
                .toList();

        Match match = Match.createMatch(
                matchCreateDto.getPlayedOn(), matchCreateDto.getSummary(), matchCreateDto.getBestOf(),
                matchCreateDto.getGameNumber(), matchCreateDto.getVods(), matchDataList
        );

        matchDataRepository.saveAll(match.getMatchDataList());
        matchRepository.save(match);

        return new MatchResponseDto(match);
    }

    public Page<Match> getAllMatches(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return matchRepository.findAll(pageRequest);
    }

    private Match findById(Long matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new BadRequestException("No match by id " + matchId));
    }
}
