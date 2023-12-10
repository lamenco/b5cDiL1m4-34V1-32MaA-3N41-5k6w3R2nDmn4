package com.example.demo.controller;

import com.example.demo.models.GasStation;
import com.example.demo.service.GasStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GasStationController {
    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping("/diesel-highest-price")
    public ResponseEntity<GasStation> gasStationWithHighestDieselPrice() {
        GasStation gasStation = gasStationService.gasStationWithHighestDieselPrice();
        return ResponseEntity.ok(gasStation);
    }

    @GetMapping("/e5-highest-price")
    public ResponseEntity<GasStation> gasStationWithHighestE5Price() {
        GasStation gasStation = gasStationService.gasStationWithHighestE5Price();
        return ResponseEntity.ok(gasStation);
    }

    @GetMapping("/e10-highest-price")
    public ResponseEntity<GasStation> gasStationWithHighestE10Price() {
        GasStation gasStation = gasStationService.gasStationWithHighestE10Price();
        return ResponseEntity.ok(gasStation);
    }

    @GetMapping("/diesel-lowest-price")
    public ResponseEntity<GasStation> gasStationWithLowestDieselPrice() {
        GasStation gasStation = gasStationService.gasStationWithLowestDieselPrice();
        return ResponseEntity.ok(gasStation);
    }

    @GetMapping("/e5-lowest-price")
    public ResponseEntity<GasStation> gasStationWithLowestE5Price() {
        GasStation gasStation = gasStationService.gasStationWithLowestE5Price();
        return ResponseEntity.ok(gasStation);
    }
    @GetMapping("/e10-lowest-price")
    public ResponseEntity<GasStation> gasStationWithLowestE10Price() {
        GasStation gasStation = gasStationService.gasStationWithLowestE10Price();
        return ResponseEntity.ok(gasStation);
    }
    @GetMapping("/DieselMiddlePrice")
    public ResponseEntity<String> midPriceDiesel() {
        double midPrice = gasStationService.middlePriceForDiesel();
        return ResponseEntity.ok(String.format("The average price for diesel is %.2f", midPrice));
    }

    @GetMapping("/E5MiddlePrice")
    public ResponseEntity<String> midPriceE5() {
        double midPrice = gasStationService.middlePriceForE5();
        return ResponseEntity.ok(String.format("The average price for fuel Е5 is %.2f", midPrice));
    }

    @GetMapping("/E10MiddlePrice")
    public ResponseEntity<String> midPriceE10() {
        double midPrice = gasStationService.middlePriceForE10();
        return ResponseEntity.ok(String.format("The average price for fuel Е10 fuel is %.2f", midPrice));
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<GasStation>> searchGasStationByName(@RequestParam("name") String name) {
        List<GasStation> gasStationsResults = gasStationService.findByName(name);
        return ResponseEntity.ok(gasStationsResults);
    }
}
