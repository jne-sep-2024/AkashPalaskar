package com.traneeSE.learn_spring_framework.Controller;

import com.traneeSE.learn_spring_framework.Config.CurrencyServiceConfiguration;
import com.traneeSE.learn_spring_framework.Pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigurationController {
    @Autowired
    private  CurrencyServiceConfiguration currencyServiceConfiguration;

    @RequestMapping("/currency-config")
    public CurrencyServiceConfiguration retriveAllCourse() {


     return currencyServiceConfiguration;
    }
}
