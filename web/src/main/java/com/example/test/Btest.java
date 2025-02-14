package com.example.test;

/**
 * @author hejing
 * @date 2025/1/9:上午9:34
 */
public class Btest {
    static {
        System.out.println("B类静态代码块开始，引用A类");
        Atest a = new Atest("B");
        System.out.println("B类静态代码块结束");
    }
}
