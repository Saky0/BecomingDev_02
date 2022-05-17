package com.bmicalculator.bmi_calculator.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "homePage/index"; 
    }
}
