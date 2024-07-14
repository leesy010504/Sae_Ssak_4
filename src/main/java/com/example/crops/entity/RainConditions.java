package com.example.crops.entity;

import jakarta.persistence.*;

@Entity
public class RainConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="rainCondition_id",nullable = false)
    private int rainConditionId;

    @Column(name = "crop_name",nullable = false)
    private String cropName;

    @Column(name = "max_rain",nullable = false)
    private int MaxRain;

    @Column(name = "min_rain",nullable = false)
    private int MinRain;

}
