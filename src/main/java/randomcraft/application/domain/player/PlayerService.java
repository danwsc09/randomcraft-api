package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;
import randomcraft.application.exception.BadRequestException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<PlayerResponseDto> findAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerResponseDto::createFrom)
                .toList();
    }

    @Transactional
    public PlayerResponseDto updatePlayerInfo(Long playerId, PlayerInfoUpdateDto playerInfoUpdateDto) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new BadRequestException("No such player"));

        Player updatedPlayer = player.updatePlayerInfo(playerInfoUpdateDto);

        return PlayerResponseDto.createFrom(updatedPlayer);
    }
}
