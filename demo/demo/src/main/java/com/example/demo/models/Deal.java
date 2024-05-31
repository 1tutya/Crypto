package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="dealsDataTable")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String date;
    private String type;
    private double price;
    private double volume;
    private String coin_name;
    private String coin_code;
    @ManyToMany(mappedBy = "deals")
    private List<Portfolio> portfolios;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

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

    public Deal(String date, String type, double price, double volume, String coin_name, String coin_code) {
        this.date = date;
        this.type = type;
        this.price = price;
        this.volume = volume;
        this.coin_name = coin_name;
        this.coin_code = coin_code;
    }

    public Deal() {
    }
}
