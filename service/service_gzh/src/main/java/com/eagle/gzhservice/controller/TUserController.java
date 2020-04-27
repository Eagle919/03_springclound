package com.eagle.gzhservice.controller;


import com.atguigu.commonutils.R;
import com.eagle.gzhservice.entity.TUser;
import com.eagle.gzhservice.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Eagle
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/gzh/user")
public class TUserController {

    @Resource
    private TUserService userService;


    @GetMapping("/list")
    public R UserList() {
        List<TUser> users = userService.list(null);
        return R.ok().data("users",users);
    }

}

