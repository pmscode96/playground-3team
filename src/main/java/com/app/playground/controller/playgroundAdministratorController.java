package com.app.playground.controller;

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
@RequestMapping("/administrator/*")
public class playgroundAdministratorController {

    @GetMapping("administratorIdFind")
    public void Move_administratorIdFind(){;}

    @GetMapping("administratorIdFindSuccess")
    public void Move_administratorIdFindSuccess(){;}

    @GetMapping("administratorJoin")
    public void Move_administratorJoin(){;}

    @GetMapping("administratorLogin")
    public void Move_administratorLogin(){;}

    @GetMapping("administratorPageMainNoListPostManage")
    public void Move_administratorPageMainNoListPostManage(){;}

    @GetMapping("administratorPageMainNoListQuestionManage")
    public void Move_administratorPageMainNoListQuestionManage(){;}

    @GetMapping("administratorPageMainNoListSchoolManage")
    public void Move_administratorPageMainNoListSchoolManage(){;}

    @GetMapping("administratorPageMainNoListUserManage")
    public void Move_administratorPageMainNoListUserManage(){;}

    @GetMapping("administratorPageMainUseListPostManage")
    public void Move_administratorPageMainUseListPostManage(){;}

    @GetMapping("administratorPageMainUseListQuestionManage")
    public void Move_administratorPageMainUseListQuestionManage(){;}

    @GetMapping("administratorPageMainUseListSchoolManage")
    public void Move_administratorPageMainUseListSchoolManage(){;}

    @GetMapping("administratorPageMainUseListUserManage")
    public void Move_administratorPageMainUseListUserManage(){;}

    @GetMapping("administratorPagePostDetail")
    public void Move_administratorPagePostDetail(){;}

    @GetMapping("administratorPagePostDetail2")
    public void Move_administratorPagePostDetail2(){;}

    @GetMapping("administratorPagePostDetailNoComment")
    public void Move_administratorPagePostDetailNoComment(){;}

    @GetMapping("administratorPagePostFixAndDel")
    public void Move_administratorPagePostFixAndDel(){;}

    @GetMapping("administratorPagePostFixAndDel2")
    public void Move_administratorPagePostFixAndDel2(){;}

    @GetMapping("administratorPageRegisterSchool")
    public void Move_administratorPageRegisterSchool(){;}

    @GetMapping("administratorPageRegisterUsers")
    public void Move_administratorPageRegisterUsers(){;}

    @GetMapping("administratorPasswordFind")
    public void Move_administratorPasswordFind(){;}

    @GetMapping("administratorPasswordFindSuccess")
    public void Move_administratorPasswordFindSuccess(){;}
}
