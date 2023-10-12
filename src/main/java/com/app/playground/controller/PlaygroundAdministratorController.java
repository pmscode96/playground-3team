package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/administrator/*")
public class PlaygroundAdministratorController {

    @GetMapping("administrator-id-find")
    public void Move_administratorIdFind(){;}

    @GetMapping("administrator-id-find-success")
    public void Move_administratorIdFindSuccess(){;}

    @GetMapping("administrator-join")
    public void Move_administratorJoin(){;}

    @GetMapping("administrator-login")
    public void Move_administratorLogin(){;}

    @GetMapping("administrator-page-main-no-list-post-manage")
    public void Move_administratorPageMainNoListPostManage(){;}

    @GetMapping("administrator-page-main-no-list-question-manage")
    public void Move_administratorPageMainNoListQuestionManage(){;}

    @GetMapping("administrator=page-main-no-list-school-manage")
    public void Move_administratorPageMainNoListSchoolManage(){;}

    @GetMapping("administrator-page-main-no-list-user-manage")
    public void Move_administratorPageMainNoListUserManage(){;}

    @GetMapping("administrator-page-main-use-list-post-manage")
    public void Move_administratorPageMainUseListPostManage(){;}

    @GetMapping("administrator-page-main-use-list-question-manage")
    public void Move_administratorPageMainUseListQuestionManage(){;}

    @GetMapping("administrator-page-main-use-list-school-manage")
    public void Move_administratorPageMainUseListSchoolManage(){;}

    @GetMapping("administrator-page-main-use-list-user-manage")
    public void Move_administratorPageMainUseListUserManage(){;}

    @GetMapping("administrator-page-post-detail")
    public void Move_administratorPagePostDetail(){;}

    @GetMapping("administrator-page-post-detail2")
    public void Move_administratorPagePostDetail2(){;}

    @GetMapping("administrator-page-post-detail-no-comment")
    public void Move_administratorPagePostDetailNoComment(){;}

    @GetMapping("administrator-page-post-fix-and-del")
    public void Move_administratorPagePostFixAndDel(){;}

    @GetMapping("administrator-page-post-fix-and-del2")
    public void Move_administratorPagePostFixAndDel2(){;}

    @GetMapping("administrator-page-register-school")
    public void Move_administratorPageRegisterSchool(){;}

    @GetMapping("administrator-page-register-users")
    public void Move_administratorPageRegisterUsers(){;}

    @GetMapping("administrator-password-find")
    public void Move_administratorPasswordFind(){;}

    @GetMapping("administrator-password-find-success")
    public void Move_administratorPasswordFindSuccess(){;}
}
