package com.example.crops.controller;

import com.example.crops.Crops;
import com.example.crops.service.CropConditionsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CropsController {

    private final CropConditionsService cropsService;
    private final CropConditionsService cropConditionsService;

    public CropsController(CropConditionsService cropsService, CropConditionsService cropConditionsService) {
        this.cropsService = cropsService;
        this.cropConditionsService = cropConditionsService;
    }

//    //모델과 연결 -> year, month, region
//    @GetMapping("/{year}/{month}/{region}")
//    public List<String> getCrops(@PathVariable int year, @PathVariable int month, @PathVariable String region) {
//
//    }

    //프론트에서 받아옴. -> year, region, crop_name
    @GetMapping("/{year}/{region}/{crop_name}")
    public List<String> getCrops(@PathVariable int year, @PathVariable String region, @PathVariable String cropName) {
        Crops crop = new Crops(year, region, cropName);

        // 지역과 년도에 맞는 예측 강수량과 온도 반환.
        // crop_name에 맞는 최고/최저 강수량/온도 반환.


    }


}
