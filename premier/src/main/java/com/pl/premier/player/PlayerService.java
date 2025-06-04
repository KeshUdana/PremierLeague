package com.pl.premier.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
    pub
}
