package com.sea.ad.register.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx48475
 * @version Id: DemoController.java, v 0.1 2018年02月06 18:05 lx48475 Exp $
 */
@RestController
@RequestMapping("default_api")
public class DemoController {
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, defaultValue = "test") String name) {
        return "Hello! " + name;
    }
}
