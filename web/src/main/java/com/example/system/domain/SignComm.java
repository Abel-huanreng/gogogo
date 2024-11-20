package com.example.system.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hejing
 * @date 2024/10/15:上午9:57
 */
public class SignComm {
    public static String calculateSignature(String data, String secretKey) throws NoSuchAlgorithmException {
        // 将数据和密钥组合在一起
        String combinedData = data + secretKey;
        // 使用 SHA-256 算法计算哈希值
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(combinedData.getBytes());
        // 将哈希值转换为十六进制字符串表示
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
