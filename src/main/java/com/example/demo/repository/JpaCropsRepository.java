package com.example.demo.repository;

import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaCropsRepository implements CropsRepository{

    EntityManager em;

    @Autowired
    public JpaCropsRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Long> getYearRain(int year, String location) {
        String jpql = "SELECT r.Jan, r.Feb, r.Mar, r.Apr, r.May, r.Jun, r.Jul, r.Aug, r.Sep, r.Oct, r.Nov, r.Dec FROM RainAmount r WHERE r.Year = :year AND r.Location = :location";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setParameter("year", year);
        query.setParameter("location", location);
        List<Object[]> results = query.getResultList();

        if (!results.isEmpty()) {
            Object[] row = results.get(0);
            return List.of((Long) row[0], (Long) row[1], (Long) row[2], (Long) row[3], (Long) row[4], (Long) row[5], (Long) row[6], (Long) row[7], (Long) row[8], (Long) row[9], (Long) row[10], (Long) row[11]);
        }
        return List.of();
    }
}
