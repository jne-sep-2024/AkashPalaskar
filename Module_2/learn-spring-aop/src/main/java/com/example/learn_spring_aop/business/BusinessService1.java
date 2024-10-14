package com.example.learn_spring_aop.business;

import com.example.learn_spring_aop.annotation.TrackTime;
import com.example.learn_spring_aop.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    //    @Autowired
    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.retriveData();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        throw new RuntimeException("Something Went Wrong");
        return Arrays.stream(data).max().orElse(0);
    }
}
