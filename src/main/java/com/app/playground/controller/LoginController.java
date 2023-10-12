package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {

    @GetMapping("/id-find")
    public void goToIdFind(){;}

    @GetMapping("/id-find-success")
    public void goToIdFindSuccess(){;}

    @GetMapping("/join")
    public void goToJoinForm(){;}

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
