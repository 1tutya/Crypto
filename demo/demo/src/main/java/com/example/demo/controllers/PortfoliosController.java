package com.example.demo.controllers;

import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/portfolio")
public class PortfoliosController {
    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private DealRepository dealRepository;

    @GetMapping
    public List<Portfolio> getPortfolios() {
        Iterable<Portfolio> portfoliosIterable = portfolioRepository.findAll();
        List<Portfolio> portfolios = new ArrayList<>();
        portfoliosIterable.forEach(portfolios::add);
        return portfolios;
    }

    @PostMapping("/add")
    public List<Portfolio> addPortfolio(@RequestBody Portfolio portfolio) {
        portfolioRepository.save(portfolio);
        Iterable<Portfolio> portfoliosIterable = portfolioRepository.findAll();
        List<Portfolio> portfolios = new ArrayList<>();
        portfoliosIterable.forEach(portfolios::add);
        return portfolios;
    }

    @PostMapping("/{portfolioId}/add-coin")
    public ResponseEntity<String> addCoinToPortfolio(@PathVariable Long portfolioId, @RequestParam Long coinId) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(portfolioId);
        Optional<Coin> coinOptional = coinRepository.findById(coinId);

        if (portfolioOptional.isEmpty() || coinOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Portfolio portfolio = portfolioOptional.get();
        Coin coin = coinOptional.get();

        portfolio.getCoins().add(coin);
        portfolioRepository.save(portfolio);

        return ResponseEntity.ok("Coin added to portfolio successfully");
    }

    @PostMapping("/{portfolioId}/add-deal")
    public ResponseEntity<String> addDealToPortfolio(@PathVariable Long portfolioId, @RequestParam Long dealId) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(portfolioId);
        Optional<Deal> dealOptional = dealRepository.findById(dealId);

        if (portfolioOptional.isEmpty() || dealOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Portfolio portfolio = portfolioOptional.get();
        Deal deal = dealOptional.get();

        portfolio.getDeals().add(deal);
        portfolioRepository.save(portfolio);

        return ResponseEntity.ok("Deal added to portfolio successfully");
    }
}
