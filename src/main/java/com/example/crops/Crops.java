package com.example.crops;

public record Crops(
        int cropCondition_id,
        String cropName,
        Integer cropCondition_temper,
        Integer cropCondition_rain
) {}