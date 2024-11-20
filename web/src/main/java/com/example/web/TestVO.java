package com.example.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author hejing
 * @date 2022/7/29:11:05
 */
@Data
public class TestVO {
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
}
