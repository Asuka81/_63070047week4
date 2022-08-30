package com.example._63070047week4;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") Double num1, @PathVariable("n2") Double num2) {
        return (num1+num2);
    }
    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") Double num1, @PathVariable("n2") Double num2) {
        return (num1-num2);
    }

    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("n1") Double num1, @PathVariable("n2") Double num2) {
        return (num1*num2);
    }

    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("n1") Double num1, @PathVariable("n2") Double num2) {
        return (num1/num2);
    }

    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("n1") Double num1, @PathVariable("n2") Double num2) {
        return (num1%num2);
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestBody MultiValueMap<String, String> n) {
        Map<String, String> d = n.toSingleValueMap();
        double num1 = Double.parseDouble(d.get("n1"));
        double num2 = Double.parseDouble(d.get("n2"));
        if(num1 > num2){
            return num1+"";
        }
        else {
            return num2+"";
        }
    }
}
