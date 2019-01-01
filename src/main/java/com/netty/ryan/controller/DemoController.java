package com.netty.ryan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ryan on 2018/12/31.
 */
@RestController
@RequestMapping("/ryan")
public class DemoController {
    @RequestMapping("/netty")
    public String test(){
        return "Welcome to Netty world!";
    }
}
