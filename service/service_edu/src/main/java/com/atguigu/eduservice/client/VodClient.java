package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * note4feign:微服务调用流程
 * 1 maven引入服务调用依赖
 * 2 启动类启用服务调用功能 EnableFeignClients
 * 3 在调用端创建interface，使用注解指定调用红服务名称，定义调用方法的路径
 * 4 注入VodClient 并调用相应方法实现逻辑
 * <p>
 * note4hystrix:4 指定实现类的调用失败class fallback = VodFileDegradeFeignClient.class
 */
@FeignClient(name = "service-vod", fallback = VodFileDegradeFeignClient.class) //调用的服务名称
@Component
public interface VodClient {

    //定义调用的方法路径
    //根据视频id删除阿里云视频
    //@PathVariable注解一定要指定参数名称，否则出错
    @DeleteMapping("/eduvod/video/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

    //定义调用删除多个视频的方法
    //删除多个阿里云视频的方法
    //参数多个视频id  List videoIdList
    @DeleteMapping("/eduvod/video/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);
}
