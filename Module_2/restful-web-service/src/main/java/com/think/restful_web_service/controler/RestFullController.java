package com.think.restful_web_service.controler;

import com.think.restful_web_service.dao.HelloRest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestFullController {

//    @RequestMapping(method = RequestMethod.GET,path = "/rest")
    @GetMapping("/rest")
    public String rest(){
        return "RestFull Controller";
    }
    @GetMapping("/hello")
    public HelloRest hello(){
        return new HelloRest("RestFull Controller");
    }

    @GetMapping("/hello/path/{name}")
    public HelloRest helloPath(@PathVariable String name){
        return new HelloRest("RestFull Controller "+name );
    }
}
