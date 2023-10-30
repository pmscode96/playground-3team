package com.app.playground.controller;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.MainService;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/*")
public class MainController {
    private final MainService mainService;
    private final PostService postService;
    private final HttpSession session;


    @GetMapping("")
    public String goToHome(Model model){
        Optional<ReplyDTO> replyDTO = mainService.selectBestReply();
        if(replyDTO.isPresent()){
            model.addAttribute("reply", replyDTO);
        }
        model.addAttribute("postCount", mainService.selectPostCount());
        model.addAttribute("posts", mainService.randomList());

        return "main/main-page";
    }

    @PostMapping("/post-detail")
    public RedirectView goToPostDetail(PostDTO postDTO){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        if(Objects.equals(postDTO.getCategory(), "free")){
            Optional<FreePostDTO> foundPost = postService.freePostDetail(postDTO.getId(), null);
            if(foundPost.isPresent()){
                replys.setPostId(foundPost.get().getId());
                replys.setUserId(user.getId());
                session.setAttribute("post", foundPost.get());
                session.setAttribute("replys", postService.freePostReplyList(replys));
                return new RedirectView("/post/free-post-detail");
            }
        }else if(Objects.equals(postDTO.getCategory(), "consulting")){
            Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(postDTO.getId(), null);
            if(foundPost.isPresent()){
                replys.setPostId(foundPost.get().getId());
                replys.setUserId(user.getId());
                session.setAttribute("post", foundPost.get());
                session.setAttribute("replys", postService.consultingPostReplyList(replys));
                return new RedirectView("/post/consulting-post-detail");
            }
        }
        return new RedirectView("");
    }

}
