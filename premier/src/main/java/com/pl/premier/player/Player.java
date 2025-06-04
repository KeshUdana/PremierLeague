package com.pl.premier.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player stats")
public class Player {
    @Id
    @Column(name= "name",unique = true)
    private String playerName;

    private String nationality;
    private String position;
    private String gender;
    private Integer age;
    private Integer mp;
    private Integer starts;
    private Double min;
    private Double gls;
    private Double ast;
    private Double pk;
    private Double crdy;
    private Double crdr;
    private Double xg;
    private Double xag;
    private String team;

    public Player() {}

    public Player(String playerName, String nationality, String position, String gender, Integer age, Integer mp, Integer starts, Double min, Double gls, Double ast, Double pk, Double crdy, Double crdr, Double xg, Double xag, String team) {

        this.playerName = playerName;
        this.nationality = nationality;
        this.position = position;
        this.gender = gender;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.min = min;
        this.gls = gls;
        this.ast = ast;
        this.pk = pk;
        this.crdy = crdy;
        this.crdr = crdr;
        this.xg = xg;
        this.xag = xag;
        this.team = team;
    }
    public Player(String playerName){
        this.playerName = playerName;
    }
    public String getPlayerName() {return playerName;}
    public void setPlayerName(String playerName) {this.playerName = playerName;}

    public String getTeam(){
        return team;
    }
}
