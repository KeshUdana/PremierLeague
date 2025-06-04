package com.pl.premier.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*This interface is for doing crud operations related to players
*  */
@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {
     void deleteByPlayerName(String playerName);
     Optional<Player> findByPlayerName(String playerName);

}
