package com.example.crops.controller;

import com.example.crops.service.CropsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CropsController {

    private final CropsService cropsService;

    public CropsController(CropsService cropsService) {
        this.cropsService = cropsService;
    }

    //모델과 연결 -> year, month, region
    @GetMapping("/{year}/{month}/{region}")
    public List<String> getCrops(@PathVariable int year, @PathVariable int month, @PathVariable String region) {

    }

    //프론트에서 받아옴. -> year, region, crop_name
    @GetMapping("/{year}/{region}/{crop_name}")
    public List<String> getCrops(@PathVariable int year, @PathVariable String region, @PathVariable String crop_name) {
        return cropsService.getCrops(year, region, crop_name);

    }


}
