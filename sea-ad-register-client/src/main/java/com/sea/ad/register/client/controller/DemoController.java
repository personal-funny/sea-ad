package com.sea.ad.register.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.util.StringUtils;
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
    @HystrixCommand(fallbackMethod = "hasError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "300")
    })
    public String hello(@RequestParam(required = true) String name) {
        if (StringUtils.isEmpty(name)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello! " + name;
    }

    public String hasError(String name) {
        return "出错了！";
    }
}
