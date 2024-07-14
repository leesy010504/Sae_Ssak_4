package com.example.crops.service;

import com.example.crops.entity.Input;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JpaInputRepository implements InputRepository{

    EntityManager em;

    @Autowired
    public JpaInputRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Input saveInput(Input input) {
        em.persist(input);
        return input;
    }
}