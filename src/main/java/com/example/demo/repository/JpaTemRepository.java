package com.example.demo.repository;

import com.example.demo.domain.Input;
import com.example.demo.domain.Tem;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaTemRepository implements TemRepository{

    EntityManager em;

    @Autowired
    public JpaTemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Tem saveTem(Tem tem) {
        em.persist(tem);
        return tem;
    }
}
