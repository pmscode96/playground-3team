package com.app.playground.controller;

import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.InquirePostVO;
import com.app.playground.domain.VO.PostVO;
import com.app.playground.domain.VO.ReplyVO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.InquirePostService;
import com.app.playground.service.PostService;
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

import javax.servlet.http.HttpServletRequest;
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
    private final PostService postService;
    private final InquirePostService inquirePostService;

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



    @GetMapping("/my-page")
    public void goToMyPage(Model model, Pagination pagination, Search search, HttpServletRequest request){;
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

        String keyword = "";
        if((String)request.getParameter("keyword")!=null) {
            keyword = (String) request.getParameter("keyword");
        }
        pagination.setTotal(postService.selectTotalFreePost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        search.setKeyword(keyword);

        model.addAttribute("posts", postService.freePostList(pagination, search, keyword, ((UserVO) session.getAttribute("user")).getId()));
        model.addAttribute("keyword",keyword);
    }

    @PostMapping("/free-post-update")
    public RedirectView postUpdate(PostVO postVO){
        postService.postUpdate(postVO);
        return new RedirectView("/mypage/my-page");
    }

    @PostMapping("/free-post-delete")
    public RedirectView postDelete(Long id){
        postService.freePostDelete(id);
        return new RedirectView("/mypage/my-page");
    }

    @GetMapping("/my-page-consulting")
    public void goToMyPageConsulting(Model model, Pagination pagination, Search search, HttpServletRequest request){;
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

        String keyword = "";
        if((String)request.getParameter("keyword")!=null) {
            keyword = (String) request.getParameter("keyword");
        }
        pagination.setTotal(postService.selectTotalConsultingPost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        search.setKeyword(keyword);

        model.addAttribute("posts", postService.consultingPostList(pagination, search, keyword, ((UserVO) session.getAttribute("user")).getId()));
        model.addAttribute("keyword",keyword);
    }

    @PostMapping("/consulting-post-update")
    public RedirectView consultingPostUpdate(PostVO postVO){
        postService.postUpdate(postVO);
        return new RedirectView("/mypage/my-page-consulting");
    }

    @PostMapping("/consulting-post-delete")
    public RedirectView consultingPostDelete(Long id){
        postService.consultingPostDelete(id);
        return new RedirectView("/mypage/my-page-consulting");
    }

    @GetMapping("/my-page-inquiry")
    public void goToInquiry(Model model, Pagination pagination, Search search, HttpServletRequest request){;
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

        String keyword = "";
        if((String)request.getParameter("keyword")!=null) {
            keyword = (String) request.getParameter("keyword");
        }
        pagination.setTotal(inquirePostService.listTotal(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        search.setKeyword(keyword);

        model.addAttribute("posts", inquirePostService.postList(pagination, search, keyword, ((UserVO) session.getAttribute("user")).getId()));
        model.addAttribute("keyword",keyword);
    }

    @PostMapping("/inquiry-post-update")
    public RedirectView inquiryPostUpdate(InquirePostVO inquirePostVO){
        inquirePostService.update(inquirePostVO);
        return new RedirectView("/mypage/my-page-consulting");
    }

    @PostMapping("/inquiry-post-delete")
    public RedirectView inquiryPostDelete(Long id){
        postService.consultingPostDelete(id);
        return new RedirectView("/mypage/my-page-consulting");
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
