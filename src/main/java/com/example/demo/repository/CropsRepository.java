package com.example.demo.repository;

import java.util.List;

public interface CropsRepository {
    public List<?> getYearRain(int year, String location);
}
