package com.sea.ad.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lx48475
 * @version Id: EurekaServiceApplication.java, v 0.1 2018年02月06 16:44 lx48475 Exp $
 */
@EnableEurekaServer //开启eureka服务
@SpringBootApplication //springBoot注解,spring在springBoot基础之上来构建项目
public class EurekaServiceApplication {

    // spirng boot的标准入口
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

}
