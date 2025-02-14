package com.example.learn.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        int port = 55533;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("服务端启动，等待客户端连接...");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("客户端已连接: " + socket.getInetAddress().getHostAddress());

                    // 获取输入输出流
                    try (
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true)
                    ) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println("从客户端获取到的消息: " + line);

                            // 检测退出命令
                            if ("exit".equalsIgnoreCase(line.trim())) {
                                System.out.println("收到退出指令，关闭客户端连接...");
                                writer.println("服务端已收到退出指令，连接关闭");
                                break;
                            }

                            // 回复消息
                            writer.println("服务端已收到: " + line);
                        }
                    } catch (IOException e) {
                        System.err.println("处理客户端数据时发生错误: " + e.getMessage());
                    }

                } catch (IOException e) {
                    System.err.println("客户端连接异常: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("服务端启动失败: " + e.getMessage());
        }

        System.out.println("服务端已关闭");
    }
}
