package com.sea.ad.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Chris
 * @version Id: ConfigServiceApplication.java, v 0.1 2018年02月14 20:12 Chris Exp $
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }
}
