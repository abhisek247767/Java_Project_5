package com.first.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class restcontroller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping("/balance")
    public String getBalanceStatement() {
        String balanceStatement = "Your home balance statement goes here";
        return balanceStatement;
    }
    @GetMapping("/contact")
    public String getContact() {
        String contact = "Hi my contacts goes here";

        return contact;
    }
}