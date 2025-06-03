package com.pl.premier.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="player stats")
public class Player {
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
    private Double team;


}
