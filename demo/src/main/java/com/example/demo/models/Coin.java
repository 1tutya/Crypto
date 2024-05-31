package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="coinsDataTable")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String coin_name;
    private String coin_code;
    private double price;
    private double _1h;
    private double _24h;
    private double _7d;
    private double market_cap;
    private double volume;
    @ElementCollection
    private List<Integer> last_price;
    @ManyToMany(mappedBy = "coins")
    private List<Portfolio> portfolios;

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getCoin_code() {
        return coin_code;
    }

    public void setCoin_code(String coin_code) {
        this.coin_code = coin_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double get_1h() {
        return _1h;
    }

    public void set_1h(double _1h) {
        this._1h = _1h;
    }

    public double get_24h() {
        return _24h;
    }

    public void set_24h(double _24h) {
        this._24h = _24h;
    }

    public double get_7d() {
        return _7d;
    }

    public void set_7d(double _7d) {
        this._7d = _7d;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(double market_cap) {
        this.market_cap = market_cap;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public List<Integer> getLast_price() {
        return last_price;
    }

    public void setLast_price(List<Integer> last_price) {
        this.last_price = last_price;
    }

    public Coin(String coin_name, String coin_code, double price, double _1h, double _24h, double _7d, double market_cap, double volume, List<Integer> last_price) {
        this.coin_name = coin_name;
        this.coin_code = coin_code;
        this.price = price;
        this._1h = _1h;
        this._24h = _24h;
        this._7d = _7d;
        this.market_cap = market_cap;
        this.volume = volume;
        this.last_price = last_price;
    }

    public Coin() {
    }
}
