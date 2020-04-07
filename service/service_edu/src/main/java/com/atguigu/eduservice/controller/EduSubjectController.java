package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-02-29
 */

/**
 * note4easyExcel:对excel读写操作框架
 * 1 写 读
 * a 安装依赖
 * b 引入poi依赖，因为easyExcel是对poi的封装
 * c 新建实体 并标注对应注解 （在测试里com.atguigu.demo.excel.DemoData）
 * d 测试 读写 com.atguigu.demo.excel.TestEasyExcel
 * 2 课程分类应用easyExcel框架步骤
 * 1> 引入相关依赖
 * 2> 使用代码生成器生成课程分类代码
 * 3> 添加课程分类 获取上传过来文件，把文件内容读取出来
 * 4> 获取上传过来excel文件
 * 5> 建立跟excel对应的实体类 com.atguigu.eduservice.entity.excel.SubjectData
 * 6> 获取文件输入流  InputStream in = file.getInputStream();
 * 7> 调用方法读取  EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
 * 8> 建立监听器类并写相关逻辑 com.atguigu.eduservice.listener.SubjectExcelListener
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    //note4easyExcel
    //添加课程分类
    //获取上传过来文件，把文件内容读取出来
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        //上传过来excel文件
        subjectService.saveSubject(file, subjectService);
        return R.ok();
    }

    //课程分类列表（树形）
    @GetMapping("getAllSubject")
    public R getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return R.ok().data("list", list);
    }

}

