package com.app.playground.controller;

import com.app.playground.domain.VO.AdministratorVO;
import com.app.playground.domain.VO.NoticeVO;
import com.app.playground.repository.AdministratorDAO;
import com.app.playground.service.AdministratorService;
import com.app.playground.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.PanelUI;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/administrator/*")
public class PlaygroundAdministratorController {
    private final HttpSession session;
    private final AdministratorService administratorService;
    private final NoticeService noticeService;

    @GetMapping("administrator-id-find")
    public void Move_administratorIdFind(){;}

    @GetMapping("administrator-id-find-success")
    public void Move_administratorIdFindSuccess(){;}

    @GetMapping("administrator-join")
    public void Move_administratorJoin(AdministratorVO administratorVO){;}

    @PostMapping("administrator-join")
    public RedirectView joinAdministrator(AdministratorVO administratorVO, RedirectAttributes attributes){
        Optional<AdministratorVO> foundAdministratorId = administratorService.getAdministratorId(administratorVO.getAdministratorId());
//        log.info(String.valueOf(foundAdministratorId));
        if(foundAdministratorId.isPresent()){
            attributes.addAttribute("foundId", false);
            return new RedirectView("/administrator/administrator-join");
        }else{
            if(administratorVO.getAdministratorPassword().equals(administratorVO.getAdministratorPasswordCheck())){
                administratorService.joinAdministrator(administratorVO, null);
                return new RedirectView("administrator-login");
            }else{
                attributes.addFlashAttribute("passwordCheck",false);
                return new RedirectView("/administrator/administrator-join");
            }
        }
    }

    @GetMapping("administrator-login")
    public void Move_administratorLogin(AdministratorVO administratorVO){;}

    @PostMapping("administrator-login")
    public RedirectView login_administrator(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){
        Optional<AdministratorVO> foundAdministrator = administratorService.loginAdministrator(administratorVO);

        if (foundAdministrator.isPresent()){
            session.setAttribute("administrator", foundAdministrator.get());
//            log.info(String.valueOf(foundAdministrator.get().getId()));
            attributes.addFlashAttribute("administratorLoginCheck", true);
            session.setAttribute("loginId", administratorVO.getAdministratorId());
            session.setAttribute("Id", String.valueOf(foundAdministrator.get().getId()));
            log.info(String.valueOf(foundAdministrator));
            return new RedirectView("/administrator/administrator-page-main-no-list-post-manage");
        }else{
            attributes.addFlashAttribute("administratorLoginCheck", false);
            return new RedirectView("administrator-login");
        }
    }

    @GetMapping("administrator-page-main-no-list-post-manage")
    public void Move_administratorPageMainNoListPostManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){
        NoticeVO noticeVO = new NoticeVO();
//      log.info((String) session.getAttribute("loginId"));
//        log.info((String) session.getAttribute("Id"));
      String loginId = (String) session.getAttribute("loginId");
      String Id = (String) session.getAttribute("Id");

      if(loginId.isEmpty()){

      }else {
          session.setAttribute("loginId",loginId);
          session.setAttribute("Id",Id);
      }
    }

    @GetMapping("administrator-page-main-no-list-question-manage")
    public void Move_administratorPageMainNoListQuestionManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator=page-main-no-list-school-manage")
    public void Move_administratorPageMainNoListSchoolManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-main-no-list-user-manage")
    public void Move_administratorPageMainNoListUserManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-main-use-list-post-manage")
    public void Move_administratorPageMainUseListPostManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-main-use-list-question-manage")
    public void Move_administratorPageMainUseListQuestionManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-main-use-list-school-manage")
    public void Move_administratorPageMainUseListSchoolManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-main-use-list-user-manage")
    public void Move_administratorPageMainUseListUserManage(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-post-detail")
    public void Move_administratorPagePostDetail(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-post-detail2")
    public void Move_administratorPagePostDetail2(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-post-detail-no-comment")
    public void Move_administratorPagePostDetailNoComment(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @PostMapping("administrator-page-post-register")
    public RedirectView Move_NoticePostRegister(NoticeVO noticeVO,HttpSession session, RedirectAttributes attributes){
        String loginId = (String) session.getAttribute("loginId");
        String Id = (String) session.getAttribute("Id");
        log.info((String) session.getAttribute("loginId"));
        log.info((String) session.getAttribute("Id"));
        if(loginId.isEmpty()){
            return null;
        }else {
            session.setAttribute("loginId",loginId);
            session.setAttribute("Id",Id);
            noticeService.create(noticeVO);
            return new RedirectView("/administrator/administrator-page-main-no-list-post-manage");

        }
    }

    @GetMapping("administrator-page-post-register")
    public void Move_administratorPagePostRegister(NoticeVO noticeVO,RedirectAttributes attributes){;}

    @GetMapping("administrator-page-post-fix-and-del")
    public void Move_administratorPagePostFixAndDel(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-post-fix-and-del2")
    public void Move_administratorPagePostFixAndDel2(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-register-school")
    public void Move_administratorPageRegisterSchool(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-page-register-users")
    public void Move_administratorPageRegisterUsers(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-password-find")
    public void Move_administratorPasswordFind(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}

    @GetMapping("administrator-password-find-success")
    public void Move_administratorPasswordFindSuccess(AdministratorVO administratorVO, HttpSession session, RedirectAttributes attributes){;}
}
