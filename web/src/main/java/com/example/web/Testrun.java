package com.example.web;

import org.springframework.stereotype.Service;

/**
 * @author hejing
 * @date 2022/7/29:16:43
 */
@Service
public class Testrun {
    private boolean type;
    public void runnow (){
       if (!type) {
           System.out.println("yes!");
           type=true;
       } else {
           System.out.println("no!");
       }
    }
}
