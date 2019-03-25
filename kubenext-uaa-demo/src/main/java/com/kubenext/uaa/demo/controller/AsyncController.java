package com.kubenext.uaa.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping("/order")
    public String order() {
        logger.info("主线程开始");
        logger.info("主线程结束");
        return "success";
    }

}
