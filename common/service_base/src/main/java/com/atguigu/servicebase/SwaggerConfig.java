package com.atguigu.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * note4Swagger:
 * 1 作用
 * 1.1 生成在线接口文档
 * 1.2 方便接口测试
 *
 * 2 使用
 * 2.1 创建共功模块，整合swagger - 创建commonm模块并添加swagger依赖
 * 2.2 在公共模块创建一个service_base模块
 * 2.3 在service_base模块创建一个配置类SwaggerConfig.class
 * 2.4 跟进配置注解修改相关信息
 * 2.5 在需要用的模块引入swagger所在的模块进去
 * 2.6 因为这个是配置类，所以项目启动就要加载即需要在用到的模块启动类上扫描到该包
 */
//note4Swagger:2.3
@Configuration//配置类
@EnableSwagger2 //swagger注解
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //.paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

    }

    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("网站-课程中心API文档")
                .description("本文档描述了课程中心微服务接口定义")
                .version("1.0")
                .contact(new Contact("java", "http://atguigu.com", "1123@qq.com"))
                .build();
    }
}
