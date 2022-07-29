package com.example.web;

import java.io.PrintStream;

public class ServletInitializer  {

    public void init(){
//        System.out.println("\033[30;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[31;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[32;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[33;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[34;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[35;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[36;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[37;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[40;31;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[41;32;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[42;33;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[43;34;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[44;35;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[45;36;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[46;37;4m" + "我滴个颜什" + "\033[0m");
//        System.out.println("\033[47;4m" + "我滴个颜什" + "\033[0m");
        PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if (x.contains("h")||x.contains("e")||x.contains("j")||x.contains("i")||x.contains("n")||x.contains("g")) {
                    super.println("\033[32;4m" + x + "\033[0m");
                }else {
                    super.println("\033[31;4m" + x + "\033[0m");
                }
            }
        };
        System.setOut(myStream);
    }

}
