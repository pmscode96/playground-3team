package com.app.playground.controller;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MyPageController {
    private final UserService userService;

    @GetMapping("/edit-profile")
    public void goToEditProfile(){
        ;
    }

    @GetMapping("/inquiry")
    public void goToInquiry(){;}

    @GetMapping("/my-page")
    public void goToMyPage(String userEmail, Model model){;
        log.info("들어옴");
//        model.addAttribute("user",userService.getUser(userEmail).get());
    }



    @GetMapping("/preferences")
    public void goToPreferences(){;}

    @GetMapping("/service-agreement")
    public void goToServiceAgreement(){;}

    @GetMapping("/sign-out")
    public void goToSignOut(){;}

    @GetMapping("/third-party-agreement")
    public void goToThirdPartyAgreement(){;}
}
