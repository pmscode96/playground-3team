package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FragmentController {

    @GetMapping("/fragment/header")
    public void header(){

    }

    @GetMapping("/fragment/footer")
    public void footer(){

    }
}
