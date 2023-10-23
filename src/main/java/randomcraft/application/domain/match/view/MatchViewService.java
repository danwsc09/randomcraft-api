package randomcraft.application.domain.match.view;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.ability.Ability;
import randomcraft.application.domain.ability.AbilityRepository;
import randomcraft.application.domain.match.Match;
import randomcraft.application.domain.match.MatchData;
import randomcraft.application.domain.match.MatchDataRepository;
import randomcraft.application.domain.match.MatchRepository;
import randomcraft.application.domain.match.dto.MatchCreateDto;
import randomcraft.application.domain.player.Player;
import randomcraft.application.domain.player.PlayerRepository;
import randomcraft.application.exception.generic.ScBadRequestException;
import randomcraft.application.exception.generic.ScNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchViewService {

    private final MatchDataRepository matchDataRepository;
    private final MatchRepository matchRepository;
    private final AbilityRepository abilityRepository;
    private final PlayerRepository playerRepository;


    public Page<Match> getAllMatches(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return matchRepository.findAll(pageRequest);
    }

    @Transactional
    public Match createMatch(MatchCreateDto matchCreateDto) {

        List<MatchData> matchDataList = matchCreateDto.getMatchItems().stream()
                .map(item -> {
                    Ability ability = abilityRepository.findById(item.getAbilityId())
                            .orElseThrow(() -> new ScBadRequestException("No ability by id " + item.getAbilityId()));

                    Player player = playerRepository.findById(item.getPlayerId())
                            .orElseThrow(() -> new ScBadRequestException("No player by id " + item.getPlayerId()));

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

        return match;
    }

    public Match getMatchById(Long matchId) {

        return matchRepository.findById(matchId)
                .orElseThrow(() -> new ScNotFoundException(String.format("No match by id: %d", matchId)));
    }

    public void deleteMatchById(Long id) {
        matchRepository.deleteById(id);
    }

}
