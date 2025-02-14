package com.example.test;

import java.io.Closeable;

/**
 * @author hejing
 * @date 2025/2/12:下午3:44
 */
public class TestService implements Closeable {
    @Override
    public void close() {
        System.out.println("关闭");
    }

    public void test() {
        System.out.println("test");
    }
}
