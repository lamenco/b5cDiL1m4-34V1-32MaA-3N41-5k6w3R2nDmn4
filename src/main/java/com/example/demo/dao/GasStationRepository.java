package com.example.demo.dao;

import com.example.demo.models.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation,String> {
    GasStation findFirstByOrderByDieselDesc();
    GasStation findFirstByDieselNotNullOrderByDieselAsc();
    GasStation findFirstByE5NotNullOrderByDieselAsc();
    GasStation findFirstByE10NotNullOrderByDieselAsc();
    GasStation findFirstByOrderByE5Desc();
    GasStation findFirstByOrderByE10Desc();
    List<GasStation> findAllByDieselNotNull();

    List<GasStation> findAllByE5NotNull();

    List<GasStation> findAllByE10NotNull();
    List<GasStation> findAllByNameContainingIgnoreCase(String name);
}
