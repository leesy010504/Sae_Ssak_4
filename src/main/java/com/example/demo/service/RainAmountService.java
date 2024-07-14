package com.example.demo.service;

import com.example.demo.domain.RainAmount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RainAmountService {

    public List<RainAmount> getRainAmount(int year, String region){
        List<RainAmount> list = new ArrayList<>();
        RainAmount rainAmount = new RainAmount("testRegion", 2026, 224L, 23414L, 13L, 13213L, 21313L, 12312L, 123123L, 123123L, 12312L, 12312L, 21312L, 12312L);
        list.add(rainAmount);
        return list;
    }
}
