package com.example.learn.stream;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * @author hejing
 * @date 2024/12/30:上午10:33
 */
public class StreamTest {
    public static void main(String[] args) {
        URL url=StreamTest.class.getClassLoader().getResource("temp.txt");
        File txtFile=new File(url.getFile());
        //打印文件内容
        try {
            FileInputStream inputStream=new FileInputStream(txtFile);
            int i=0;
            while ((i=inputStream.read())!=-1){
                System.out.print((char)i);
            }
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
