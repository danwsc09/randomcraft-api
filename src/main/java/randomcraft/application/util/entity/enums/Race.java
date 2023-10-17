package randomcraft.application.util.entity.enums;

import java.util.List;

public enum Race {
    ZERG("Z"), PROTOSS("P"), TERRAN("T");

    public final static List<Race> raceList = List.of(Race.ZERG, Race.PROTOSS, Race.TERRAN);

    final String letter;

    Race(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
