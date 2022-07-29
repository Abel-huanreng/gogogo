package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

/**
 * @author hejing
 * @date 2022/7/28:17:08
 */
@RestController
public class Hejing {
    @GetMapping("/myIndex")
    public String index() {
        PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println(System.currentTimeMillis() + ": " + x);
            }
        };
        System.setOut(myStream);
        System.out.println("\033[40;31;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("Hello World!");
        return "index1";
    }
}
