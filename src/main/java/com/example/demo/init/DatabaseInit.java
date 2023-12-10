package com.example.demo.init;

import com.example.demo.service.GasStationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final GasStationService gasStationService;

    public DatabaseInit(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @Override
    public void run(String... args) throws Exception {
        gasStationService.init();
    }
}
