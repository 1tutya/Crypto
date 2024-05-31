package com.example.demo.controllers;

import com.example.demo.models.Deal;
import com.example.demo.models.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deals")
public class DealsController {
    @Autowired
    private DealRepository dealRepository;

    @GetMapping
    public List<Deal> getDeals() {
        Iterable<Deal> dealsIterable = dealRepository.findAll();
        List<Deal> deals = new ArrayList<>();
        dealsIterable.forEach(deals::add);
        return deals;
    }

    @PostMapping("/add")
    public List<Deal> addDeal(@RequestBody Deal deal) {
        dealRepository.save(deal);
        Iterable<Deal> dealsIterable = dealRepository.findAll();
        List<Deal> deals = new ArrayList<>();
        dealsIterable.forEach(deals::add);
        return deals;
    }
}
