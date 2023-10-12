package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customer-service-center/*")
public class CustomerServiceCenterController {

    @GetMapping("/customer-service-center-contact-us")
    public void goToCustomerServiceCenterContactUs(){;}

    @GetMapping("/customer-service-center-main")
    public void goToCustomerServiceCenterMain(){;}


}
