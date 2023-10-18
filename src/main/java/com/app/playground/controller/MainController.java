package com.app.playground.controller;

import com.app.playground.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/*")
public class MainController {
    private final MainService mainService;


    @GetMapping("/")
    public String goToHome(Model model){
        model.addAttribute("reply", mainService.selectBestReply());
        model.addAttribute("postCount", mainService.selectPostCount());

        return "main/main-page";
    }
}
