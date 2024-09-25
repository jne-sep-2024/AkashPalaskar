package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.a0.BusinessCalculationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("com.traneeSE.learn_spring_framework.BusinessCalculationService")
public class MySqlDataService implements DataService{
    @Override
    public int[] retriveData() {
        return new int[]{1,2,3,4,5};
    }
}
