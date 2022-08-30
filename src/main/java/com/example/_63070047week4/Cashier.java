package com.example._63070047week4;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{n1}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("n1") Integer cash) {
        Change c = new Change();
        while (cash > 0){
        if (cash >= 1000){
            c.setB1000(c.getB1000()+1);
            cash = cash-1000;
        } else if (cash >= 500) {
            c.setB500(c.getB500()+1);
            cash = cash-500;
        } else if (cash >= 100) {
            c.setB100(c.getB100()+1);
            cash = cash-100;
        } else if (cash >= 20) {
            c.setB20(c.getB20()+1);
            cash = cash-20;
        } else if (cash >= 10) {
            c.setB10(c.getB10()+1);
            cash = cash-10;
        } else if (cash >= 5) {
            c.setB5(c.getB5()+1);
            cash = cash-5;
        }else {
            c.setB1(c.getB1()+1);
            cash = cash-1;
        }
        }
        return c;
    }
}
