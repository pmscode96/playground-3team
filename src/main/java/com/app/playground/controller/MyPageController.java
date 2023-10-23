package com.app.playground.controller;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.Optional;

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
    public void goToMyPage(Model model){;}


    @GetMapping("/preferences")
    public void goToPreferences(HttpSession session, Model model){;
        UserVO user = (UserVO)session.getAttribute("user");
        Optional<UserVO> kakaoUser = userService.getKakaoUser(user.getUserEmail());
        log.info(String.valueOf(kakaoUser));
        if(kakaoUser.isPresent() && !Objects.equals(user.getId(), kakaoUser.get().getId())){
            model.addAttribute("sync" ,  true);
        } else {
            model.addAttribute("sync" ,  false);
        }
    }


    @GetMapping("/service-agreement")
    public void goToServiceAgreement(){;}

    @GetMapping("/sign-out")
    public void goToSignOut(){;}

    @PostMapping("/sign-out")
    public RedirectView SignOut(HttpSession session){
        UserVO userVO = (UserVO)session.getAttribute("user");
        userService.delete(userVO.getId());
        session.invalidate();
        return new RedirectView("/");
    }

    @GetMapping("/third-party-agreement")
    public void goToThirdPartyAgreement(){;}
}
