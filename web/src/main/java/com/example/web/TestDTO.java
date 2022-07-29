package com.example.web;


import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hejing
 * @date 2022/7/29:10:27
 */
@Data
public class TestDTO {
    @NotNull(message = "参数string不能为空！")
    private String string;
}
