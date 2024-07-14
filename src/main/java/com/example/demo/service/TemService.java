package com.example.demo.service;

import com.example.demo.domain.Tem;
import com.example.demo.dto.TemForm;
import com.example.demo.repository.TemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemService {

    private TemRepository temRepository;

    @Autowired
    public TemService(TemRepository temRepository) {
        this.temRepository = temRepository;
    }

    public Tem saveTem(TemForm form) {
        Tem tem = new Tem(
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
        return temRepository.saveTem(tem);
    }
}
