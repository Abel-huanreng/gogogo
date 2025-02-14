package com.example.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.zip.GZIPOutputStream;

/**
 * @author hejing
 * @date 2024/8/21:下午5:21
 */
public class Test {
    public static void main(String[] args) throws SQLException {
//        String sourceFilePath = "D:/tw/test.txt";
//
//        String outputFilePath = "D:/tw/test.txt.gz"; // 压缩文件路径
//        try {
//            compressFile(outputFilePath, sourceFilePath);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        FileUtil.del("D:/tw/test.txt~/01");
//        FileUtil.mkdir("D:/tw/test.txt~/01");
//        FileUtil.touch("D:/tw/test.txt~/01/1.txt.ok");
        // 获取今天的 0 点
        //将字符串7F5E转为16进制
        String str="7F5E";

        //将字符串7F5E转为16进制
        System.out.println(Integer.parseInt(str,16));

    }



    /**
     * 压缩文件
     *
     * @param outputFilePath 压缩文件路径
     * @param sourceFilePath 源文件路径
     * @throws IOException 如果文件读写失败
     */
    private static void compressFile(String outputFilePath, String sourceFilePath) throws IOException {
        // 使用 try-with-resources 自动关闭流
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath);
             GZIPOutputStream gzos = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024]; // 缓冲区
            int length;

            // 读取源文件并写入 GZIP 输出流
            while ((length = fis.read(buffer)) != -1) {
                gzos.write(buffer, 0, length);
            }
            gzos.finish(); // 完成 GZIP 输出
        }
    }



}


