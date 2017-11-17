package com.greenfox.csomam.orientationexam.modules;

import javax.persistence.*;

@Entity
@Table(name = "licence_plates")
public class LicencePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String plate;
    private String car_brand;
    private String car_model;
    private String color;
    private int year;

    public LicencePlate(String plate, String car_brand, String car_model, String color, int year) {
        this.plate = plate;
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.color = color;
        this.year = year;
    }

    public LicencePlate() {
    }

    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
