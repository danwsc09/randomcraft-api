package randomcraft.application.domain.player.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import randomcraft.application.util.entity.enums.Race;
import randomcraft.application.domain.player.Player;
import randomcraft.application.util.Constants;

import java.time.OffsetDateTime;


@Getter
public class PlayerResponseDto {
    private Long id;
    private String name;
    private String inGameName;
    private String afreecaName;
    private String youtubeName;
    private Race race;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN_FULL_DATE, timezone = Constants.TIME_ZONE)
    private OffsetDateTime lastPlayed;

    public static PlayerResponseDto createFrom(Player player) {
        PlayerResponseDto result = new PlayerResponseDto();

        result.id = player.getId();
        result.name = player.getName();
        result.inGameName = player.getInGameName();
        result.afreecaName = player.getAfreecaName();
        result.youtubeName = player.getYoutubeName();
        result.race = player.getRace();
        result.lastPlayed = player.getLastPlayed();

        return result;
    }
}
