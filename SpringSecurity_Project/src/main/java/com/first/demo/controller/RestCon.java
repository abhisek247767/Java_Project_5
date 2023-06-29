package com.first.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCon {
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
        String contact = "Hi, my contacts go here";
        return contact;
    }

}
