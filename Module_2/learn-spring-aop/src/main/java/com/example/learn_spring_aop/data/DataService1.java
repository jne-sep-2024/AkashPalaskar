package com.example.learn_spring_aop.data;

import com.example.learn_spring_aop.annotation.TrackTime;
import org.springframework.stereotype.Component;

@Component
public class DataService1 {
    @TrackTime
    public int[] retriveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
}
