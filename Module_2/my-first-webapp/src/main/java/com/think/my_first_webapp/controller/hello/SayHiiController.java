package com.think.my_first_webapp.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
public class SayHiiController {

    //    @GetMapping("/say-hello")
    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, what are you learning today!!";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>hello app</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(" my first html web app");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("/say-hello-jsp")
//    @ResponseBody
    public String sayHelloJsp() {
        System.out.println("hello");
        return "sayHello";
    }

}
