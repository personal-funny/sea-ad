package com.sea.ad.cas.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lx48475
 * @version Id: CasServerApplication.java, v 0.1 2018年02月07 16:19 lx48475 Exp $
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CasServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasServerApplication.class, args);
    }

}
