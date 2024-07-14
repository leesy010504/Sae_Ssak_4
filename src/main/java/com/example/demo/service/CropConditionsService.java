package com.example.demo.service;

import com.example.crops.CropsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CropConditionsService {
    private final CropsRepository cropsRepository;

    public CropConditionsService(CropsRepository cropsRepository) {
        this.cropsRepository = cropsRepository;
    }

    @Transactional
    public List<String> getCrops(int year, String region, String cropName) {
        List<String> optimalRainAndTem = new ArrayList<>();

        Long cropId = CropsRepository.findCropName(cropName);



        //지역이랑
        //cropName으로 Id 찾고, 그에 따른 온도랑 강수량 범위 값을 찾아 보내주기.


        return optimalRainAndTem;



    }
}
