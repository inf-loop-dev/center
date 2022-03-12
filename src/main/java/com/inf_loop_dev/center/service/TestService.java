package com.inf_loop_dev.center.service;

import com.inf_loop_dev.center.domain.Test;
import com.inf_loop_dev.center.repository.TestRepository;
import com.inf_loop_dev.center.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test addTest(String title, String contents){
        Test testDTO = new Test();
        testDTO.setTitle(title);
        testDTO.setContents(contents);
        return testRepository.save(testDTO);
    }


    public Test readTest(long id) {
        return testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    @Transactional
    public Test modifyTest(long id, TestDTO testVO) {
        Test testDTO= testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
        testDTO.setTitle(testVO.getTitle());
        testDTO.setContents(testVO.getContents());
        return testDTO;
    }

    public String deleteTest(long id) {
        try {
            testRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            return "삭제 실패함" + e.toString();
        }
        return "삭제 성공함";
    }
}
