package com.sea.ad.register.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chris
 * @version Id: MessageRestController.java, v 0.1 2018年02月15 00:53 Chris Exp $
 */
@RefreshScope
@RestController
@RequestMapping("config_api")
public class MessageRestController {

    @Value("${message:Hello Default}")
    private String message;

    @RequestMapping("get_message")
    public String getMessage() {
        return message;
    }
}
