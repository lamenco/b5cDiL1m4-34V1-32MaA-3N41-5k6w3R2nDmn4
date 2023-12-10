package com.example.demo.service;

import com.example.demo.dao.GasStationRepository;
import com.example.demo.models.GasStation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GasStationService {
    private final GasStationRepository gasStationRepository;

    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public void init() {
        if (gasStationRepository.count() == 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<GasStation> gasStations = objectMapper.readValue(new File("src/data.json"),
                        new TypeReference<List<GasStation>>() {
                        });
                gasStations.stream()
                        .filter(GasStation::getIsOpen)
                        .collect(Collectors.toList());
                gasStationRepository.saveAll(gasStations);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public GasStation gasStationWithHighestDieselPrice() {
        GasStation gasStation = gasStationRepository.findFirstByOrderByDieselDesc();
        return gasStation;
    }

    public GasStation gasStationWithHighestE5Price() {
        GasStation gasStation = gasStationRepository.findFirstByOrderByE5Desc();
        return gasStation;
    }

    public GasStation gasStationWithHighestE10Price() {
        GasStation gasStation = gasStationRepository.findFirstByOrderByE10Desc();
        return gasStation;
    }

    public GasStation gasStationWithLowestDieselPrice() {
        GasStation gasStation = gasStationRepository.findFirstByDieselNotNullOrderByDieselAsc();
        return gasStation;
    }
    public GasStation gasStationWithLowestE5Price() {
        GasStation gasStation = gasStationRepository.findFirstByE5NotNullOrderByDieselAsc();
        return gasStation;
    }
    public GasStation gasStationWithLowestE10Price() {
        GasStation gasStation = gasStationRepository.findFirstByE10NotNullOrderByDieselAsc();
        return gasStation;
    }

    public double middlePriceForDiesel() {
        List<GasStation> gasStations = gasStationRepository.findAllByDieselNotNull();
        double averageDieselPrice = gasStations.stream()
                .mapToDouble(GasStation::getDiesel)
                .average().orElse(0.0);
        return averageDieselPrice;
    }

    public double middlePriceForE5() {
        List<GasStation> gasStations = gasStationRepository.findAllByE5NotNull();
        double averageE5Price = gasStations.stream()
                .mapToDouble(GasStation::getE5)
                .average().orElse(0.0);
        return averageE5Price;
    }

    public double middlePriceForE10() {
        List<GasStation> gasStations = gasStationRepository.findAllByE10NotNull();
        double averageE10Price = gasStations.stream()
                .mapToDouble(GasStation::getE10)
                .average().orElse(0.0);

        return averageE10Price;
    }


    public List<GasStation> findByName(String name) {
        List<GasStation> gasStations = gasStationRepository.findAllByNameContainingIgnoreCase(name);
        return gasStations;
    }
}
