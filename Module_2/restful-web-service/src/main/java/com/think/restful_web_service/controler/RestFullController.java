package com.think.restful_web_service.controler;

import com.think.restful_web_service.dao.HelloRest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class RestFullController {

    private MessageSource messageSource;

    public RestFullController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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
    @GetMapping("/hello/international")
    public String helloIntrenational(){

        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage("good.morning.message",null,"Defalut Message",locale);
//        return "Hello";
    }
}
