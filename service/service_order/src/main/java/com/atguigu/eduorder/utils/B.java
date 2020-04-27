package com.atguigu.eduorder.utils;


/**
 * note4extends:
 * 1 字类继承父类，就会继承父类的代码块及构造器
 * 2 类成员变量加载顺序：静态代码块 > 父代码块 > 父构造器 > 自己代码块 > 自己构造器
 */
public class B extends A {
    public B() {
        System.out.println("4 = " + 4);
    }

    {
        System.out.println("5 = " + 5);
    }

    static {
        System.out.println("6 = " + 6);

    }

    public static void main(String[] args) {
        B b = new B();
    }
}
