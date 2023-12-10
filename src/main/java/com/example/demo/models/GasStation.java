package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "stations")
@Data
public class GasStation {

    @Id
    private String id;
    private String name;
    private String brand;
    private String street;
    private String place;
    private double lat;
    private double lng;
    private double dist;
    private Double diesel;
    private Double e5;
    private Double e10;
    private Boolean isOpen;
    private String houseNumber;
    private int postCode;

    public GasStation() {
    }
}
