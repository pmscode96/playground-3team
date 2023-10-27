package com.app.playground.controller;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.PostVO;
import com.app.playground.domain.VO.ReplyVO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {
    public final PostService postService;
    private final HttpSession session;

    @GetMapping("/charge")
    public void goToPostCharge(){;}

    @GetMapping("/expected-problem")
    public void goToExpectedProblem(){;}

    @GetMapping("/expected-problem-detail")
    public void goToExpectedProblemDetail(){;}

    @GetMapping("/free-post")
    public void goToFreePost(Pagination pagination, Search search, Model model, HttpServletRequest request){
        String keyword = "";
        Long userId = null;
        if((String)request.getParameter("keyword")!=null) {
            keyword = (String) request.getParameter("keyword");
        }
        pagination.setTotal(postService.selectTotalFreePost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        search.setKeyword(keyword);

        model.addAttribute("posts", postService.freePostList(pagination, search, keyword, userId));
        model.addAttribute("keyword",keyword);
    }

    @PostMapping("/free-post")
    public RedirectView goToJoinFreePostDetail(Long id, HttpSession session, Model model) {
        Optional<FreePostDTO> foundPost = postService.freePostDetail(id);
        if(foundPost.isPresent()){
            log.info("들어옴");
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(foundPost.get().getId()));
            return new RedirectView("/post/free-post-detail");
        }
        log.info("못들어옴");
        return new RedirectView("/post/free-post");
    }

    @GetMapping("/free-post-detail")
    public void goToPostDetail(FreePostDTO freePostDTO){
        UserVO user = (UserVO) session.getAttribute("user");
    }

    @PostMapping("/free-post-detail")
    public RedirectView  createReply(ReplyDTO replyDTO){
        postService.freePostReplyInsert(replyDTO);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(replyDTO.getPostId());
        if(foundPost.isPresent()){
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(foundPost.get().getId()));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post-detail");
    }

    @PostMapping("/free-post-reply-delete")
    public RedirectView deleteReplyFreePost(Long replyId, Long postId){
        log.info(replyId.toString());
        log.info(postId.toString());

        postService.freePostReplyLikeDeleteAllByReplyId(replyId);
        postService.freePostReplyDelete(replyId);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(postId);
        if(foundPost.isPresent()){
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(foundPost.get().getId()));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post-detail");
    }

    @PostMapping("/free-post-reply-update")
    public RedirectView updateReplyFreePost(ReplyVO replyVO, Long postId){
        postService.replyUpdate(replyVO);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(postId);
        if(foundPost.isPresent()){
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(foundPost.get().getId()));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post-detail");
    }

    @GetMapping("/consulting-post")
    public void goToConsultingPost(Pagination pagination, Search search, Model model, HttpServletRequest request){
        String keyword = "";
        Long userId = null;
        if((String)request.getParameter("keyword")!=null) {
            keyword = (String) request.getParameter("keyword");
        }
        pagination.setTotal(postService.selectTotalConsultingPost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        search.setKeyword(keyword);

        model.addAttribute("posts", postService.consultingPostList(pagination, search, keyword, userId));
        model.addAttribute("keyword",keyword);
    }

    @PostMapping("/consulting-post")
    public RedirectView goToJoinConsultingPostDetail(Long id, HttpSession session, Model model) {
        Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(id);
        if(foundPost.isPresent()){
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.consultingPostReplyList(foundPost.get().getId()));
            return new RedirectView("/post/consulting-post-detail");
        }
        log.info("못들어옴");
        return new RedirectView("/post/consulting-post");
    }

    @GetMapping("/consulting-post-detail")
    public void goToConsultingPostDetail(ConsultingPostDTO consultingPostDTO){;}

    @GetMapping("/most-recommended-posts")
    public void goToMostRecommendedPosts(){;}

    @GetMapping("/most-recommended-posts-detail")
    public void goToMostRecommendedPostsDetail(){;}

    @GetMapping("/school-post")
    public void goToSchoolPost(){;}

    @GetMapping("/free-write")
    public void goToFreeWrite(){;}

    @PostMapping("/free-write")
    public RedirectView freePostCreate(PostDTO postDTO){
        postDTO.setCategory("free");
        postService.createFreePost(postDTO);
        return new RedirectView("/post/free-post");
    }

    @GetMapping("/free-update")
    public void goToFreeUpdate(PostDTO postDTO){;}

    @PostMapping("/free-update")
    public RedirectView freeUpdate(PostVO postVO){
        postService.postUpdate(postVO);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(postVO.getId());
        if(foundPost.isPresent()){
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(foundPost.get().getId()));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post");
    }

    @GetMapping("/consulting-write")
    public void goToConsultingWrite(){;}
}
