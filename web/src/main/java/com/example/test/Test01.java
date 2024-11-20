package com.example.test;

import lombok.Data;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author hejing
 * @date 2024/7/2:上午8:43
 */
@Data

public class Test01 {
    public static void main(String[] args) {
        Do obj = (Do) Proxy.newProxyInstance(DoImpl.class.getClassLoader(), DoImpl.class.getInterfaces(), (proxy, method, args1) -> {
            System.out.println("before:" + Arrays.toString(args1));
            String arg = (String) args1[0];
            if (arg.contains("jj")) {
                System.out.println("oh ,no no no ......");
                throw new RuntimeException("this method is not ok");
            }
            Object re = method.invoke(new DoImpl(), args1);
            System.out.println("after");
            return re;
        });
        String oo = obj.test("hhhhhh");
        System.out.println(oo);
        System.out.println("---------------------------------------------------");

        TwoDo twoDo= (TwoDo) CglibProxyFactory.getProxy(TwoDo.class);
        twoDo.test("jjj");
    }



}

