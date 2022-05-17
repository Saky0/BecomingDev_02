package com.bmicalculator.bmi_calculator.view.controller;

import java.util.List;

import com.bmicalculator.bmi_calculator.service.BmiService;
import com.bmicalculator.bmi_calculator.shared.BmiDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TableHistoryController {

    @Autowired
    private BmiService service;
    
    @RequestMapping(value="/bmi", method=RequestMethod.GET)
    public ModelAndView requestMethodName() {
        ModelAndView mv = new ModelAndView("tableHistoryPage/index");
        List<BmiDto> bmis = service.getAllBmi();
        mv.addObject("bmis", bmis);
        return mv;
    }
     
}
