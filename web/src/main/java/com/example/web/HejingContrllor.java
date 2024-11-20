package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hejing
 * @date 2022/7/28:17:08
 */
@RestController
public class HejingContrllor {
    List<String> sList = new ArrayList<>();
    @Autowired
    Testrun testrun;

    @PostMapping("/myIndex")
    public TestVO index(@Valid @RequestBody TestDTO testDTO) {
        TestVO testVO = new TestVO();
        testVO.setId(System.currentTimeMillis());
        testVO.setName(testDTO.getString());
        testVO.setDate(testDTO.getDate());
        System.out.println(testDTO.getString());
        sList.add(testDTO.getString());
        return testVO;
    }

    @GetMapping("/look")
    public String index2() {
        String s = "";
        if (sList.size() > 0) {
            s = sList.get(0);
            sList.clear();
        }
        return s;
    }
}
