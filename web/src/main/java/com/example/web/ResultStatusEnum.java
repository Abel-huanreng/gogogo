package com.example.web;

/**
 * @author hejing
 * @date 2022/7/29:14:31
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public enum ResultStatusEnum {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功！"),
    /**
     * 业务异常
     */
    ERROR(400,"error"),

    /**
     * 密码错误
     */
    PASSWORD_NOT_MATCHING(400, "密码错误");

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;
}
