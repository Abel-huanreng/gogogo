package com.example.web;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hejing
 * @date 2022/7/29:16:43
 */
@Service
public class Testrun {
    private boolean type;
    public void runnow (){
       if (!type) {
           System.out.println("yes!"+null+"djsakd");
           type=true;
       } else {
           String ds=null;
           String dd = null;
           System.out.println("no!"+ds+"ds"+dd);
       }
    }
    /**
     * 演示map的用途：一对一转换
     */
    public void stringToIntMap() {
        List<String> ids = Arrays.asList("205","105","308","469","627","193","111");
        // 使用流操作
        List<Integer> results = ids.stream()
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());
        System.out.println(results);
        String string="dskal\ndj;l,";
        System.out.println(string.substring(0,string.length() - 1));
    }
}
