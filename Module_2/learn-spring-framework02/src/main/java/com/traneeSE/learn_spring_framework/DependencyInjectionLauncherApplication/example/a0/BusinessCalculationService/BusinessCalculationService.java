package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.a0.BusinessCalculationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private DataService dataService;

    @Autowired
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findmax() {

        return Arrays.stream(dataService.retriveData()).max().orElse(0);

    }


}
