package randomcraft.application.util.entity.enums;

import java.util.List;

public enum GameResult {
    WIN("승"), LOSS("패");

    public final static List<GameResult> gameResultList = List.of(WIN, LOSS);

    String korean;

    GameResult(String koreanLabel) {
        korean = koreanLabel;
    }

    public String getKorean() {
        return korean;
    }
}
