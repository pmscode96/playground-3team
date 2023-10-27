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
    private final HttpSession session;

    @GetMapping("/id-find")
    public void goToIdFind(UserVO userVO){;}

    @PostMapping("/id-find")
    public RedirectView idFind(UserVO userVO, Model model) {
        Optional<UserVO> foundUser = userService.findId(userVO);
        if(foundUser.isPresent()){
            session.setAttribute("user", foundUser.get());
            return new RedirectView("id-find-success");
        }
        return new RedirectView("id-find");
    }

    @GetMapping("/id-find-success")
    public void goToIdFindSuccess(UserVO userVO, Model model) {
        UserVO currentUser = (UserVO)session.getAttribute("user");
        if (currentUser != null) {
            Optional<UserVO> foundUser = userService.getUserById(currentUser.getId());
            if (foundUser.isPresent()) {
                log.info(foundUser.get().toString());
                model.addAttribute("user", foundUser.get());
                session.invalidate();
            } else {
                log.error("User not found with id: " + currentUser.getId());
                // Handle user not found case
            }
        } else {
            log.error("No user in session");
            // Handle no user in session case
        }
    }

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
    public void goToPasswordFind(UserVO userVO){;}

    @PostMapping("/password-find")
    public RedirectView pwFind(UserVO userVO, Model model) {
        Long id = userService.findPw(userVO);
        session.setAttribute("id", id);
        return new RedirectView("password-find-success");
    }

    @GetMapping("/password-find-success")
    public void goToPasswordFindSuccess(UserVO userVO, Model model){
        Long id = (Long) session.getAttribute("id");
//        if (currentUser != null) {
//            Optional<UserVO> foundUser = userService.getUserById(currentUser.getId());
//            if (foundUser.isPresent()) {
//                log.info(foundUser.get().toString());
//                model.addAttribute("user", foundUser.get());
//                session.invalidate();
//            } else {
//                log.error("User not found with id: " + currentUser.getId());
//                // Handle user not found case
//            }
//        } else {
//            log.error("No user in session");
//            // Handle no user in session case
//        }
    }

    @PostMapping("/password-find-success")
    public RedirectView updatePassword(UserVO userVO, Model model){
        Long id = (Long) session.getAttribute("id");
        userVO.setId(id);
        userService.updatePw(userVO);
        session.invalidate();
        return new RedirectView("login");
    }

    @GetMapping("/social-login")
    public void goToSchoolPost(){;}

    @GetMapping("/student-join")
    public void goToStudentJoin(){;}

    @GetMapping("/login")
    public void goToStudentOrTeacherLogin(){;}

    @PostMapping("/login")
    public RedirectView login(UserVO userVO, RedirectAttributes redirectAttributes){
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
    public RedirectView updateInfo(UserVO userVO){
        UserVO user = (UserVO) session.getAttribute("user");
        userVO.setId(user.getId());
        userService.updateInfo(userVO);
        return new RedirectView("/");
    }


}
