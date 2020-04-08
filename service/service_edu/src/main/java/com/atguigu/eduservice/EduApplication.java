package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//note4nacos:4 在启动类上加个开启启用服务注册功能的注解 EnableDiscoveryClient
@EnableDiscoveryClient  //nacos注册

//note4feign:2 启动类启用服务调用功能 EnableFeignClients
@EnableFeignClients
//note4Swagger:2.6 因为这个是配置类，所以项目启动就要加载即需要在用到的模块启动类上扫描到该包
@ComponentScan(basePackages = {"com.atguigu"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
