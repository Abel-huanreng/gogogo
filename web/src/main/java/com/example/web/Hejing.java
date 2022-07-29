package com.example.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author hejing
 * @date 2022/7/28:17:08
 */
@RestController
public class Hejing {
    @PostMapping("/myIndex")
    public TestVO index(@Valid @RequestBody TestDTO testDTO) {
        TestVO testVO = new TestVO();
        testVO.setId(System.currentTimeMillis());
        testVO.setName(testDTO.getString());
        System.out.println(testDTO.getString());
        return testVO;
    }
}
