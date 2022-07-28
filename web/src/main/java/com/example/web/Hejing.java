package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hejing
 * @date 2022/7/28:17:08
 */
@RestController
public class Hejing {
    @GetMapping("/myIndex")
    public String index() {
        System.out.println("hello.springboot的第一个controller");
        return "index1";
    }
}
