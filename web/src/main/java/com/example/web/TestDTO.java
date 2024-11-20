package com.example.web;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hejing
 * @date 2022/7/29:10:27
 */
@Data
public class TestDTO {
    @NotNull(message = "参数string不能为空！")
    private String string;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
