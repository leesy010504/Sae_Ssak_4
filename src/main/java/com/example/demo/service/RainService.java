package com.example.demo.service;

import com.example.demo.domain.Rain;
import com.example.demo.dto.RainForm;
import com.example.demo.repository.RainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RainService {

    private RainRepository rainRepository;

    @Autowired
    public RainService(RainRepository rainRepository) {
        this.rainRepository = rainRepository;
    }

    public Rain saveRain(RainForm form) {
        Rain rain = new Rain(
                form.location(),
                form.jan(),
                form.feb(),
                form.mar(),
                form.apr(),
                form.may(),
                form.jun(),
                form.jul(),
                form.aug(),
                form.sep(),
                form.oct(),
                form.nov(),
                form.dec()
        );
        return rainRepository.saveRain(rain);
    }
}