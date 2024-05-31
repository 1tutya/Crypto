package com.example.demo.controllers;

import com.example.demo.models.Exchange;
import com.example.demo.models.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exchanges")
public class ExchangesController {
    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping
    public List<Exchange> getExchanges() {
        Iterable<Exchange> exchangesIterable = exchangeRepository.findAll();
        List<Exchange> exchanges = new ArrayList<>();
        exchangesIterable.forEach(exchanges::add);
        return exchanges;
    }

    @PostMapping("/add")
    public List<Exchange> addExchange(@RequestBody Exchange exchange) {
        exchangeRepository.save(exchange);
        Iterable<Exchange> exchangesIterable = exchangeRepository.findAll();
        List<Exchange> exchanges = new ArrayList<>();
        exchangesIterable.forEach(exchanges::add);
        return exchanges;
    }
}
