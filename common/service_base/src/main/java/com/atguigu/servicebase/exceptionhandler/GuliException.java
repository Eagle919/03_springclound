package com.atguigu.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * note4exception:6 自定义异常
 * 1 创建一个类继承RuntimeException类
 * 2 生成有参数构造方法
 * 3 生成无参数构造
 * 4 生成get/set方法 @Data
 *
 */
@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class GuliException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息
}
