package com.example.test;

/**
 * @author hejing
 * @date 2024/11/20:上午10:36
 */
public class DoImpl implements Do {
    @Override
    public String test(String test) {
        System.out.println("fangfa");
        return "this is a test:"+test;
    }
}
