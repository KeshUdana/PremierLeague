package com.pl.premier.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRespository;
    @Autowired
    public PlayerService(PlayerRepository playerRespository) {
        this.playerRespository = playerRespository;
    }
    public List<Player> getPlayers() {
        return playerRespository.findAll();
    }
    public List<Player>getPlayersFromTeam(String teamName) {
        return playerRespository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayersByName(String searchText) {
        return playerRespository.findAll().stream()
                .filter(player -> player.getPlayerName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player>getPlayerByPosition(String searchText) {
        return playerRespository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player>getPlayerByNationality(String searchText) {
        return playerRespository.findAll().stream()
                .filter(player -> player.getNationality().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayerByPositionAndTeam(String position, String teamName) {
        return playerRespository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }
    public Player addPlayer(Player player) {
        playerRespository.save(player);
        return player;
    }
    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayer=playerRespository.findByPlayerName(updatedPlayer.getPlayerName());
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setPlayerName(updatedPlayer.getName());
        }
    }

}
