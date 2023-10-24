package com.app.playground.controller;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class UserController {
    private final UserService userService;

    @GetMapping("/id-find")
    public void goToIdFind(){;}

    @PostMapping("/id-find")
    public void idFind(){;

    }

    @GetMapping("/id-find-success")
    public void goToIdFindSuccess(){;}

    @GetMapping("/join")
    public void goToJoinForm(UserVO userVO, Model model){
        model.addAttribute("userSchool", userVO);
    }

    @PostMapping("join")
    public RedirectView join(UserVO userVO){
        userService.join(userVO, null);
        return new RedirectView("/login/login");
    }

//    @GetMapping("/kakao")
//    public void goToKakao(){;}

    @GetMapping("/admin-login")
    public void goToLoginForm(){;}


    @GetMapping("/password-find")
    public void goToPasswordFind(){;}

    @GetMapping("/password-find-success")
    public void goToPasswordFindSuccess(){;}

    @GetMapping("/social-login")
    public void goToSchoolPost(){;}

    @GetMapping("/student-join")
    public void goToStudentJoin(){;}

    @GetMapping("/login")
    public void goToStudentOrTeacherLogin(){;}

    @PostMapping("/login")
    public RedirectView login(UserVO userVO, HttpSession session, RedirectAttributes redirectAttributes){
        Optional<UserVO> foundUser = userService.login(userVO);
        if(foundUser.isPresent()){
            session.setAttribute("user", foundUser.get());
            return new RedirectView("/");
        }
        return new RedirectView("/login/no-login");
    }
    @GetMapping("/no-login")
    public void goToNoLogin(){;}


    @GetMapping("/teacher-and-student-join")
    public void goToTeacherAndStudentJoin(){;}

    @GetMapping("/teacher-join")
    public void goToTeacherJoin(){;}

    @GetMapping("/teacher-and-student-kakao-join")
    public void goToTeacherAndStudentKakaoJoin(){;}

    @GetMapping("/student-kakao-join")
    public void goToStudentKakoJoin(){;}

    @GetMapping("/teacher-kakao-join")
    public void goToTeacherKakaoJoin(){;}

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/login/login");
    }

    @GetMapping("update-info")
    public RedirectView updateInfo(UserVO userVO, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");
        userVO.setId(user.getId());
        userService.updateInfo(userVO);
        return new RedirectView("/");
    }


}
