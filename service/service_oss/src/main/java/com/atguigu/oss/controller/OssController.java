package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * note4oss:
 * 阿里云文件存储服务使用步骤
 * 1 开通阿里云oss服务，获取到授权key及密钥
 * 2 在pom文件引入oss依赖
 * 3 写application.properties配置文件
 * 4 启动时报错：数据源或者数据驱动找不到时，在启动类上加个注解接口解决。
 *   exclude = DataSourceAutoConfiguration.class：表示不自动加载数据源
 * 5 创建常量类ConstantPropertiesUtils.java，用于读取配置文件里的内容
 * 6 ConstantPropertiesUtils类去实现InitializingBean接口并重写afterPropertiesSet方法
 *   作用是：项目启动后spring加载之后，执行接口一个方法，将配置文件的值赋给该常量类，并执行重写的方法
 * 7 创建OssController及OssService
 * 8 uploadFileAvatar（MultipartFile file）
 * 9 前端上传头像步骤
 *      1
 *
 * note4nginx:反向代理服务器
 * 1 作用：
 *      请求转发 得到请求再将请求具体转发到对应的服务器 通过路劲匹配进行转发
 *      负载均衡 通过轮询等算法平均分发请求到不同的服务器
 *      动静分离 java代码和图片等资源进行分离
 * 2 命令
 *      cmd -> nginx.exe
 *      nginx.exe -s stop
 * 3 配置
 *      找到配置文件 conf/nginx.conf
 *      配置nginx.conf
 *          1 改默认端口80成81
 *          2 配置转发规则（需要写在http标签里）
 *              listen 9001 :表示对我监听的端口
 *              location ~ /eduservice/ { proxy_pass http://localhost:8001;} :表示当请求中包含‘eduservice’路径时转发到http://localhost:8001服务器的8001端口
 *              ~ 波浪线 ：表示当前使用正则表达式进行匹配，若不加波浪线则表示全路径匹配。
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    //上传头像的方法
    @PostMapping
    public R uploadOssFile(MultipartFile file) {
        //获取上传文件  MultipartFile
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url", url);
    }

}
