package com.example.crops.controller;

import com.example.crops.entity.Input;
import com.example.crops.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/input")
public class InputController {

    private final InputService inputService;

    @Autowired
    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    @PostMapping("/{rain}/{temperature}")
    public ResponseEntity<Input> saveInput(@PathVariable Long rain, @PathVariable Long temperature) {
        Input savedInput = inputService.saveInput(rain, temperature);
        return ResponseEntity.ok(savedInput);
    }
}