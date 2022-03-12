package com.inf_loop_dev.center.controller;

import com.inf_loop_dev.center.domain.Test;
import com.inf_loop_dev.center.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.inf_loop_dev.center.service.TestService;

@RestController
public class testController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test(){
        return "test입니다 기분 좋아요?";
    }

    @PostMapping("/test")
    public Test addTest(@RequestBody TestDTO testVO){
        return testService.addTest(testVO.getTitle(), testVO.getContents());
    }
    @GetMapping("/test/{id}")
    public Test readTest(@PathVariable("id") long id){
        return testService.readTest(id);
    }

    @PutMapping("/test/{id}")
    public Test modifyTest(@PathVariable("id") long id, @RequestBody TestDTO testVO){
        return testService.modifyTest(id,testVO);
    }
    @DeleteMapping("/test/{id}")
    public String deleteTest(@PathVariable("id") long id){
        return testService.deleteTest(id);
    }
}
