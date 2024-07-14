package com.example.demo.repository;

import com.example.demo.domain.RainAmount;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaRainRepository implements RainRepository{

    EntityManager em;

    @Autowired
    public JpaRainRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public RainAmount saveRain(RainAmount rainAmount) {
        em.persist(rainAmount);
        return rainAmount;
    }
}
