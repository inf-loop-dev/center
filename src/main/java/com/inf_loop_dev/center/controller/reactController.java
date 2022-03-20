package com.inf_loop_dev.center.controller;

import com.inf_loop_dev.center.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class reactController {

    private final HttpSession httpSession;

    @GetMapping(value = "/")
    public String index(Model model){
//        ModelAndView modelAndView = new ModelAndView();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        System.out.println("user>> "+user);
        model.addAttribute("name","홍길동");
        System.out.println("model>> "+model);
        return "index";
    }

//    @GetMapping(value = "/js/**")
//    public String js(){
//        return "index.html";
//    }    @GetMapping(value = "/")
//    public String index(){
//        return "index.html";
//    }
}
