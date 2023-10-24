package com.app.playground.controller;

import com.app.playground.service.SmsService;
import com.app.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @GetMapping("/check/sendSMS")
    public @ResponseBody
    String sendSMS(String phoneNumber) {
        log.info("들어옴");
        log.info(phoneNumber);
        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        smsService.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }
}
