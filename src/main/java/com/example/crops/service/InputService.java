package com.example.crops.service;

import com.example.crops.entity.Input;
import com.example.crops.entity.InputForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InputService {

    private InputRepository inputRepository;

    @Autowired
    public InputService(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public Input saveInput(Long rain, Long temperature){
        Input input = new Input(rain, temperature);
        return inputRepository.saveInput(input);
    }
}


