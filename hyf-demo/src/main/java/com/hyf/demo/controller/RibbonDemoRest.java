package com.hyf.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class RibbonDemoRest {

    @GetMapping
    public String dem1(){
        return "hhhhhh213231";
    }


    @GetMapping("/{id}")
    public String dem(@PathVariable Long id){
        return "hhhhhh: "+ id;
    }

}
