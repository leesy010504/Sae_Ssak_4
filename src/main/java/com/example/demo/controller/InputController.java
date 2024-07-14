package com.example.demo.controller;

import com.example.demo.domain.Rain;
import com.example.demo.domain.Tem;
import com.example.demo.dto.RainForm;
import com.example.demo.dto.TemForm;
import com.example.demo.service.RainService;
import com.example.demo.service.TemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {

    private TemService temService;
    private RainService rainService;

    @Autowired
    public void TemController(TemService temService) {
        this.temService = temService;
    }

    @Autowired
    public void RainController(RainService rainService) {
        this.rainService = rainService;
    }

    public InputController(TemService temService, RainService rainService) {
        this.temService = temService;
        this.rainService = rainService;
    }

    @PostMapping("/rain")
    public ResponseEntity<Rain> saveRain(@RequestBody RainForm form) {
        Rain savedRain = rainService.saveRain(form);
        return ResponseEntity.ok(savedRain);
    }

    @PostMapping("/tem")
    public ResponseEntity<Tem> saveTem(@RequestBody TemForm form) {
        Tem savedTem = temService.saveTem(form);
        return ResponseEntity.ok(savedTem);
    }
}
