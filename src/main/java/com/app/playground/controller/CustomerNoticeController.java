package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customer-notice/*")
public class CustomerNoticeController {

    @GetMapping("/customer-notice")
    public void goToCustomerNotice(){;}

    @GetMapping("/customer-notice-detail")
    public void goToCustomerNoticeDetail(){;}

    @GetMapping("/customer-service-notice")
    public void goToCustomerServiceNotice(){;}
}
