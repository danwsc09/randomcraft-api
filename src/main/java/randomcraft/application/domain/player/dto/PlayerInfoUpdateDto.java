package randomcraft.application.domain.player.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import randomcraft.application.base.enums.Race;

@Getter
@AllArgsConstructor
public class PlayerInfoUpdateDto {

    private String name;
    private String inGameName;
    private String afreecaName;
    private String youtubeName;
    private Race race;

}
