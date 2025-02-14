package com.example.learn.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 55533;

        try (Socket socket = new Socket(host, port);
             Scanner scanner = new Scanner(System.in);
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream()) {

            System.out.println("客户端已连接到服务端: " + host + ":" + port);

            // 输出流包装为PrintWriter便于写入
            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {

                while (true) {
                    System.out.println("请输入消息（输入exit断开连接）：");
                    String message = scanner.nextLine();

                    // 发送消息
                    writer.println(message);

                    // 检测退出指令
                    if ("exit".equalsIgnoreCase(message.trim())) {
                        System.out.println("客户端已发送退出指令，准备关闭连接...");
                        break;
                    }

                    // 接收服务端的回复
                    String response = reader.readLine();
                    System.out.println("从服务端接收到的回复: " + response);
                }
            } catch (IOException e) {
                System.err.println("与服务端通信时发生错误: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("无法连接到服务端: " + e.getMessage());
        }

        System.out.println("客户端已关闭");
    }
}
