package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="portfoliosDataTable")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    @ManyToMany
    @JoinTable(name = "portfolio_coins",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "coin_id"))
    private List<Coin> coins;
    @ManyToMany
    @JoinTable(name = "portfolio_deals",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "deal_id"))
    private List<Deal> deals;
    @ElementCollection
    private List<Double> profile_volume_usd;
    @ElementCollection
    private List<Double> profile_volume_btc;
    private double current_volume_usd;
    private double current_volume_btc;

    public List<Deal> getDeals() {
        return deals;
    }

    public void addDeal(Deal deal) { deals.add(deal);}

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public List<Double> getProfile_volume_usd() {
        return profile_volume_usd;
    }

    public void setProfile_volume_usd(List<Double> profile_volume_usd) {
        this.profile_volume_usd = profile_volume_usd;
    }

    public List<Double> getProfile_volume_btc() {
        return profile_volume_btc;
    }

    public void setProfile_volume_btc(List<Double> profile_volume_btc) {
        this.profile_volume_btc = profile_volume_btc;
    }

    public double getCurrent_volume_usd() {
        return current_volume_usd;
    }

    public void setCurrent_volume_usd(double current_volume_usd) {
        this.current_volume_usd = current_volume_usd;
    }

    public double getCurrent_volume_btc() {
        return current_volume_btc;
    }

    public void setCurrent_volume_btc(double current_volume_btc) {
        this.current_volume_btc = current_volume_btc;
    }

    public Portfolio(List<Double> profile_volume_usd, List<Double> profile_volume_btc, double current_volume_usd, double current_volume_btc) {
        this.coins = new ArrayList<>();
        this.deals = new ArrayList<>();
        this.profile_volume_usd = profile_volume_usd;
        this.profile_volume_btc = profile_volume_btc;
        this.current_volume_usd = current_volume_usd;
        this.current_volume_btc = current_volume_btc;
    }

    public Portfolio() {
    }
}