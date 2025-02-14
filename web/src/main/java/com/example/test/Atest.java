package com.example.test;

/**
 * @author hejing
 * @date 2025/1/9:上午9:34
 */
public class Atest {
    static {
        System.out.println("A类静态代码块开始，引用B类");
        Btest b = new Btest();
        System.out.println("A类静态代码块结束");
    }

    public Atest(String number) {
        System.out.println("实例化A"+number);
         class Atesttwo{
            private String name;

             public Atesttwo(String name) {
                 this.name = name;
             }

         }
    }
}
