package com.kubenext.uaa.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }

}
