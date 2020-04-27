package com.eagle.gzhservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eagle"})
public class GzhApplication {

    public static void main(String[] args) {
        SpringApplication.run(GzhApplication.class, args);
    }
}
