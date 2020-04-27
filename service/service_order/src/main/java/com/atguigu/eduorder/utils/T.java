package com.atguigu.eduorder.utils;

public class T {
    public static void main(String[] args) {
        apr26();
    }

    public static void apr26() {
        int s1 = 6724 + 5094 + 145 + 5047 + 18213 + 743 + 9821 + 4046 + 16363 + 3570;
        int s2 = 36000 + 9000 + 6000 + 19000 + 41000 + 5000 + 21000 + 5000 + 33000 + 5000;
        System.out.println("s1 = " + s1); //s1 = 69766
        System.out.println("s2 = " + s2); //s2 = 180000
        System.out.println("s2 - s1 = " + (s2 - s1 - 8492)); //s2 - s1 = 101742
    }
}
