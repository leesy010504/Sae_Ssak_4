package com.example.demo.controller;

import com.example.demo.domain.RainAmount;
import com.example.demo.service.CropConditionsService;
import com.example.demo.service.RainAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropsController {

    private final CropConditionsService cropConditionsService;
    private final RainAmountService rainAmountService;

    @Autowired
    public CropsController(CropConditionsService cropConditionsService, RainAmountService rainAmountService) {
        this.rainAmountService = rainAmountService;
        this.cropConditionsService = cropConditionsService;
    }

//    //모델과 연결 -> year, month, region
//    @GetMapping("/{year}/{month}/{region}")
//    public List<String> getCrops(@PathVariable int year, @PathVariable int month, @PathVariable String region) {
//
//    }

    //프론트에서 받아옴. -> year, region, crop_name
    @GetMapping("/{year}/{region}")
    public List<RainAmount> getCrops(@PathVariable int year, @PathVariable String region) {
        return rainAmountService.getRainAmount(year, region);
        // 지역과 년도에 맞는 예측 강수량
    }
}
