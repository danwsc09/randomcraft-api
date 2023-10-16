package randomcraft.application.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import randomcraft.application.domain.player.dto.PlayerCreateDto;
import randomcraft.application.domain.player.dto.PlayerInfoUpdateDto;
import randomcraft.application.domain.player.dto.PlayerResponseDto;
import randomcraft.application.exception.BadRequestException;
import randomcraft.application.util.response.PaginationResponse;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PaginationResponse<Player, PlayerResponseDto> findAllPlayers(PageRequest pageRequest, String name, String ign) {
        Page<Player> players = playerRepository.findAllByNameContainingIgnoreCaseAndInGameNameContainingIgnoreCase(
                name, ign, pageRequest);

        List<PlayerResponseDto> list = players.stream()
                .map(PlayerResponseDto::createFrom)
                .toList();

        return new PaginationResponse<>(players, list);
    }

    public PlayerResponseDto findPlayerById(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("No player by id: " + playerId));

        return PlayerResponseDto.createFrom(player);
    }

    @Transactional
    public PlayerResponseDto updatePlayerInfo(Long playerId, PlayerInfoUpdateDto playerInfoUpdateDto) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new BadRequestException("No such player"));

        Player updatedPlayer = player.updatePlayerInfo(playerInfoUpdateDto);

        return PlayerResponseDto.createFrom(updatedPlayer);
    }

    @Transactional
    public PlayerResponseDto createPlayer(PlayerCreateDto playerCreateDto) {

        Player player = Player.createPlayer(playerCreateDto);
        playerRepository.save(player);

        return PlayerResponseDto.createFrom(player);
    }

    public PlayerResponseDto deletePlayerById(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElse(null);

        if (player == null) return null;

        playerRepository.deleteById(playerId);
        return PlayerResponseDto.createFrom(player);
    }
}
