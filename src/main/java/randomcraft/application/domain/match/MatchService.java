package randomcraft.application.domain.match;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.ability.AbilityRepository;
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
                matchUpdateDto.getGameNumber(), matchUpdateDto.getVods(), matchDataList.toArray(new MatchData[0])
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

    public PaginationResponse<Match, MatchResponseDto> getAllMatches(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Match> matches = matchRepository.findAll(pageRequest);

        List<MatchResponseDto> list = matches.stream()
                .map(MatchResponseDto::new)
                .toList();
        return new PaginationResponse<>(matches, list);
    }

    private Match findById(Long matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new BadRequestException("No match by id " + matchId));
    }
}
