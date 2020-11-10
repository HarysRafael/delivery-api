package com.br.deliveryapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
    
}