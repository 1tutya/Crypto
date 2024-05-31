package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="exchangesDataTable")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String name;
    private double score;
    private long volume24h;
    private int markets;
    private int coins;
    @ElementCollection
    private List<Integer> last_volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(long volume24h) {
        this.volume24h = volume24h;
    }

    public int getMarkets() {
        return markets;
    }

    public void setMarkets(int markets) {
        this.markets = markets;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Integer> getLast_volume() {
        return last_volume;
    }

    public void setLast_volume(List<Integer> last_volume) {
        this.last_volume = last_volume;
    }

    public Exchange(String name, double score, long volume24h, int markets, int coins, List<Integer> last_volume) {
        this.name = name;
        this.score = score;
        this.volume24h = volume24h;
        this.markets = markets;
        this.coins = coins;
        this.last_volume = last_volume;
    }

    public Exchange() {
    }
}