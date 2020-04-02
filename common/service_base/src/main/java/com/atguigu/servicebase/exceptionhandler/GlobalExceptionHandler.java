package com.atguigu.servicebase.exceptionhandler;

import com.atguigu.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * note4exception:
 * 1 创建统一异常处理类 GlobalExceptionHandler
 * 2 在类头加@ControllerAdvice
 * Slf4j注解：主要用于将log.info或者error的信息输入到logback日志文件中
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //note4exception:3 指定出现什么异常执行这个方法,所有异常都可以用这个方法 - 全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..");
    }

    //note4exception:5 特定异常 - 将产生异常的类替换掉全局异常的Exception即可
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }

    /**
     * note4exception:6 自定义异常
     * 5 将自定义异常类加入到 @ExceptionHandler(GuliException.class) 及 error(GuliException e)里面
     * 6 返回特定结果显示
     */
    @ExceptionHandler(GuliException.class)
    @ResponseBody //为了返回数据
    public R error(GuliException e) {
        //note4exception: Slf4j注解 主要用于将log.info或者error的信息输入到logback日志文件中
        log.error(e.getMessage());
        e.printStackTrace();

        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
