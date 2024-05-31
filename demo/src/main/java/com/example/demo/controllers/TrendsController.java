package com.example.demo.controllers;

import com.example.demo.models.Trend;
import com.example.demo.models.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/trends")
public class TrendsController {
    @Autowired
    private TrendRepository trendRepository;

    @GetMapping
    public List<Trend> getTrends() {
        Iterable<Trend> trendsIterable = trendRepository.findAll();
        List<Trend> trends = new ArrayList<>();
        trendsIterable.forEach(trends::add);
        return trends;
    }

    @PostMapping("/add")
    public List<Trend> addTrend(@RequestBody Trend trend) {
        trendRepository.save(trend);
        Iterable<Trend> trendsIterable = trendRepository.findAll();
        List<Trend> trends = new ArrayList<>();
        trendsIterable.forEach(trends::add);
        return trends;
    }
}
