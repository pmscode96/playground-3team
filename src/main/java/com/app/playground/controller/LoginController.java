package com.app.playground.controller;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.UserService;
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
@RequestMapping("/login/*")
public class LoginController {
    private final UserService userService;

    @GetMapping("/id-find")
    public void goToIdFind(){;}

    @GetMapping("/id-find-success")
    public void goToIdFindSuccess(){;}

    @GetMapping("/join")
    public void goToJoinForm(UserVO userVO){;}

    @PostMapping("join")
    public RedirectView join(UserVO userVO){
        userService.join(userVO);
        return new RedirectView("/login/login");
    }

//    @GetMapping("/kakao")
//    public void goToKakao(){;}

    @GetMapping("/login")
    public void goToLoginForm(){;}

    @GetMapping("/no-login")
    public void goToNoLogin(){;}

    @GetMapping("/password-find")
    public void goToPasswordFind(){;}

    @GetMapping("/password-find-success")
    public void goToPasswordFindSuccess(){;}

    @GetMapping("/social-login")
    public void goToSchoolPost(){;}

    @GetMapping("/student-join")
    public void goToStudentJoin(){;}

    @GetMapping("/student-or-teacher-login")
    public void goToStudentOrTeacherLogin(){;}

    @GetMapping("/teacher-and-student-join")
    public void goToTeacherAndStudentJoin(){;}

    @GetMapping("/teacher-join")
    public void goToTeacherJoin(){;}
}
