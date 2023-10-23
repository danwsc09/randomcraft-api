package randomcraft.application.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import randomcraft.application.domain.match.Match;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatchUpdateDto {
    private Long id;
    private OffsetDateTime playedOn;
    private String summary;
    private Integer bestOf;
    private Integer gameNumber;
    private String vods;
    private List<MatchDataUpdateDto> matchItems;

    public static MatchUpdateDto createFromMatch(Match match) {
        MatchUpdateDto dto = new MatchUpdateDto();

        dto.id = match.getId();
        dto.playedOn = match.getPlayedOn();
        dto.summary = match.getSummary();
        dto.bestOf = match.getBestOf();
        dto.gameNumber = match.getGameNumber();
        dto.vods = match.getVods();

        dto.matchItems = match.getMatchDataList().stream()
                .map(matchData -> {
                    MatchDataUpdateDto updateDto = new MatchDataUpdateDto();
                    updateDto.setLocation(matchData.getLocation());
                    updateDto.setRace(matchData.getRace());
                    updateDto.setResult(matchData.getResult());
                    updateDto.setAbilityId(matchData.getAbility().getId());
                    updateDto.setPlayerId(matchData.getPlayer().getId());

                    return updateDto;
                })
                .toList();

        return dto;
    }
}
