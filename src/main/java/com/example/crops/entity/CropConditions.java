package com.example.crops.entity;

import jakarta.persistence.*;

@Entity
public class CropConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="cropCondition_id",nullable = false)
    private int cropCondition_id;

    @Column(name = "cropName",nullable = false)
    private String cropName;

    @Column(name = "cropCondition_temper",nullable = false)
    private int cropCondition_temper;

    @Column(name = "cropCondition_rain",nullable = false)
    private int cropCondition_rain;

}
