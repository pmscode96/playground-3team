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
    private final HttpSession session;

    @GetMapping("/edit-profile")
    public void goToEditProfile(Model model) {
        UserVO currentUser = (UserVO)session.getAttribute("user");
        if (currentUser != null) {
            Optional<UserVO> foundUser = userService.getUserById(currentUser.getId());
            if (foundUser.isPresent()) {
                log.info(foundUser.get().toString());
                model.addAttribute("user", foundUser.get());
            } else {
                log.error("User not found with id: " + currentUser.getId());
                // Handle user not found case
            }
        } else {
            log.error("No user in session");
            // Handle no user in session case
        }
    }

    @PostMapping("/edit-profile")
    public RedirectView updateProfile(UserVO userVO){
        UserVO currentUser = (UserVO)session.getAttribute("user");
        userVO.setId(currentUser.getId());
        log.info(String.valueOf(userVO));
        userService.updateUser(userVO);
//        Optional<UserVO> foundUser = userService.getUserById(userVO.getId());
//        session.setAttribute("user", foundUser);
        return new RedirectView("/mypage/my-page");
    }

    @GetMapping("/inquiry")
    public void goToInquiry(){;}

    @GetMapping("/my-page")
    public void goToMyPage(Model model){;
        UserVO currentUser = (UserVO)session.getAttribute("user");
        if (currentUser != null) {
            Optional<UserVO> foundUser = userService.getUserById(currentUser.getId());
            if (foundUser.isPresent()) {
                log.info(foundUser.get().toString());
                model.addAttribute("user", foundUser.get());
            } else {
                log.error("User not found with id: " + currentUser.getId());
                // Handle user not found case
            }
        } else {
            log.error("No user in session");
            // Handle no user in session case
        }
    }


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
