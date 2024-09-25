package com.traneeSE.learn_spring_framework.Controller;

import com.traneeSE.learn_spring_framework.Pojo.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retriveAllCourse() {


        return Arrays.asList(new Course(1, "learn AWS", "Think"),
                new Course(2, "learn DevOps", "Think"),
                new Course(3, "learn Azure", "Think"),
                new Course(4, "learn Azure", "Think")

        );
    }
}
