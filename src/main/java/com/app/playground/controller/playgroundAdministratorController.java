package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/KHJ/templates/administrator_page/*")
public class playgroundAdministratorController {

    @GetMapping("administrator_page_main_no_list_postManage")
    public void Move_No_List_PostManage(){;}
}
