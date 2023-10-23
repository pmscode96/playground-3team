package com.app.playground.controller;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.KakaoService;
import com.app.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {
    private final KakaoService kakaoService;
    private final UserService userService;

    @GetMapping("/kakao/login")
    public RedirectView login(String code, HttpSession session, RedirectAttributes redirectAttributes) {
        Long id = null;
        String token = kakaoService.getKaKaoAccessToken(code);
        Optional<UserVO> foundInfo = kakaoService.getKaKaoInfo(token);
        if (foundInfo.isPresent()){
            if(session.getAttribute("user") != null){
                id = ((UserVO)session.getAttribute("user")).getId();
            }

            log.info(String.valueOf(foundInfo));

            userService.join(foundInfo.get(), id);
            UserVO userVO = userService.getKakaoUser(foundInfo.get().getUserKakaoEmail()).get();
            session.setAttribute("user", userVO);

            if(userVO.getUserSchool() == null){
                return new RedirectView("/login/teacher-and-student-kakao-join");
            }
            return new RedirectView("/");
        }
        return new RedirectView("/login/login");
    }
}
