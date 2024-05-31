package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="trendsDataTable")
public class Trend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String coin_name;
    private String coin_code;
    private double _24h;

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

    public double get_24h() {
        return _24h;
    }

    public void set_24h(double _24h) {
        this._24h = _24h;
    }

    public Trend(String coin_name, String coin_code, double _24h) {
        this.coin_name = coin_name;
        this.coin_code = coin_code;
        this._24h = _24h;
    }

    public Trend() {
    }
}