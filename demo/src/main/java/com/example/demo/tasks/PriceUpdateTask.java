package com.example.demo.tasks;


import com.example.demo.models.Coin;
import com.example.demo.models.CoinRepository;
import com.example.demo.models.TaskLog;
import com.example.demo.models.TaskLogRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PriceUpdateTask {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private TaskLogRepository taskLogRepository;

    private static final String BITCOIN_CODE = "BTC";

    @Scheduled(cron = "0 * * * * *")
    public void updateBitcoinPrice() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        boolean success = false;

        try {
            CoinDeskResponse response = restTemplate.getForObject(url, CoinDeskResponse.class);
            double newPrice = response.getBpi().get("USD").getRateFloat();

            Iterable<Coin> coinsIterable = coinRepository.findAll();
            List<Coin> coins = new ArrayList<>();
            coinsIterable.forEach(coins::add);

            for (Coin coin : coins) {
                if (BITCOIN_CODE.equals(coin.getCoin_code())) {
                    coin.setPrice(newPrice);
                    coinRepository.save(coin);
                    break;
                }
            }
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        TaskLog log = new TaskLog(LocalDateTime.now(), success);
        taskLogRepository.save(log);

        List<TaskLog> logs = (List<TaskLog>) taskLogRepository.findAll();
        if (logs.size() > 10) {
            taskLogRepository.deleteById(logs.get(0).getId());
        }
    }

    public static class CoinDeskResponse {
        private Time time;
        private Map<String, Bpi> bpi;

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public Map<String, Bpi> getBpi() {
            return bpi;
        }

        public void setBpi(Map<String, Bpi> bpi) {
            this.bpi = bpi;
        }

        public static class Time {
            private String updated;
            private String updatedISO;
            private String updateduk;

            public String getUpdated() {
                return updated;
            }

            public void setUpdated(String updated) {
                this.updated = updated;
            }

            public String getUpdatedISO() {
                return updatedISO;
            }

            public void setUpdatedISO(String updatedISO) {
                this.updatedISO = updatedISO;
            }

            public String getUpdateduk() {
                return updateduk;
            }

            public void setUpdateduk(String updateduk) {
                this.updateduk = updateduk;
            }
        }

        public static class Bpi {
            private String code;
            private String symbol;
            private String rate;
            private String description;
            @JsonProperty("rate_float")
            private double rateFloat;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public double getRateFloat() {
                return rateFloat;
            }

            public void setRateFloat(double rateFloat) {
                this.rateFloat = rateFloat;
            }
        }
    }
}