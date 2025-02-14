package com.example.test;

import cn.hutool.core.io.file.FileReader;
import com.example.test.baidu.ocr.BaiduOcrTest;
import okhttp3.*;
import org.json.JSONException;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author hejing
 * @date 2025/2/12:下午3:44
 */
public class Test02 {
    public static void main(String[] args) throws IOException, JSONException {
        FileReader fileReader = new FileReader("D:\\codecangku\\gogogo\\web\\src\\main\\java\\com\\example\\test\\baidu\\ocr\\sfzImgBase64.txt");
        String imgBase64 = fileReader.readString();
        String urle= URLEncoder.encode(imgBase64,"utf-8");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "id_card_side=front&image="+urle+"&detect_ps=false&detect_risk=false&detect_quality=false&detect_photo=false&detect_card=false&detect_direction=false");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token="+BaiduOcrTest.getAccessToken())
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
