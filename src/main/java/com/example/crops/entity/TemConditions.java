package com.example.crops.entity;

import jakarta.persistence.*;

@Entity
public class TemConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="temCondition_id",nullable = false)
    private int temConditionId;

    @Column(name = "crop_name",nullable = false)
    private String cropName;

    @Column(name = "max_temp",nullable = false)
    private int MaxTemper;

    @Column(name = "min_temp",nullable = false)
    private int MinTemper;

}

