package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/user")
/**
 * note4跨域:
 * 1 跨域如何产生
 *      通过一个地址去访问另一个地址时，当访问协议-http/https 或者 端口号 或者ip访问地址 任何一个不一样时就会产生跨域问题
 * 2 跨域解决方案
 * 2.1 方式1 - 在controller类上加@CrossOrigin 注解即可解决跨域
 * 2.2 方式2 - 使用网关解决
 */
public class EduLoginController {
    //login
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
