package com.example.demo.repository;
import com.example.demo.domain.RainAmount;

public interface RainRepository {
    public RainAmount saveRain(RainAmount rainAmount);
}
