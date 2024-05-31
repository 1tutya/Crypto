package com.example.demo.controllers;

import com.example.demo.models.Coin;
import com.example.demo.models.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinsController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping
    public List<Coin> getCoins() {
        Iterable<Coin> coinsIterable = coinRepository.findAll();
        List<Coin> coins = new ArrayList<>();
        coinsIterable.forEach(coins::add);
        return coins;
    }

    @PostMapping("/add")
    public List<Coin> addCoin(@RequestBody Coin coin) {
        coinRepository.save(coin);
        Iterable<Coin> coinsIterable = coinRepository.findAll();
        List<Coin> coins = new ArrayList<>();
        coinsIterable.forEach(coins::add);
        return coins;
    }
}
