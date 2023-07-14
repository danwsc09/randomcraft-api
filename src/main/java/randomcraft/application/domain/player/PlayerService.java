package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import randomcraft.application.domain.player.dto.PlayerDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<PlayerDto> findAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerDto::createFrom)
                .toList();
    }
}
