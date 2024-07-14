package com.example.demo.repository;

import com.example.demo.domain.Input;
import com.example.demo.domain.Rain;
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
    public Rain saveRain(Rain rain) {
        em.persist(rain);
        return rain;
    }
}
