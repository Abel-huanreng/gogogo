package com.example.test.baidu.ocr;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

public class BaiduOcrTest {
    public static final String API_KEY = "3NwAmT5Xpn39qXBSKnPYaraQ";
    public static final String SECRET_KEY = "ekECUMw2e2k0ZJx5qV23KfdmNXss0dpL";

    public static String dizhi="C:\\Users\\abelj\\Pictures\\sfz.jpg";
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static void main(String[] args) throws IOException, JSONException {

        String imgBase64 = convertFileToBase64(dizhi);
        String urlcode= URLEncoder.encode(imgBase64,"UTF-8");
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "id_card_side=front&image="+ urlcode +"&detect_ps=false&detect_risk=false&detect_quality=false&detect_photo=false&detect_card=false&detect_direction=false");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());
    }

    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    public static String getAccessToken() throws IOException, JSONException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }

    /**
     * 将文件转换为 Base64 编码的字符串
     *
     * @param imgPath 文件路径
     * @return Base64 编码的字符串
     * @throws IOException 如果文件读取失败
     */
    public static String convertFileToBase64(String imgPath) throws IOException {
        // 使用 try-with-resources 确保 InputStream 自动关闭
        try (InputStream in = new FileInputStream(imgPath);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 读取文件内容到 ByteArrayOutputStream
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            // 对字节数组进行 Base64 编码
            return Base64.getEncoder().encodeToString(out.toByteArray());
        }
    }
}
