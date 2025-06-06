package com.pl.premier.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
    public List<Player>getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPlayerName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player>getPlayerByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player>getPlayerByNationality(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNationality().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayerByPositionAndTeam(String position, String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }
    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }
    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByPlayerName(updatedPlayer.getPlayerName());
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setPlayerName(updatedPlayer.getPlayerName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setNationality(updatedPlayer.getNationality());
            // Update other fields as necessary

            return playerRepository.save(playerToUpdate);
        } else {
            // Optional: throw exception or handle player not found
            throw new RuntimeException("Player not found: " + updatedPlayer.getPlayerName());
        }
    }
    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByPlayerName(playerName);
    }
}
