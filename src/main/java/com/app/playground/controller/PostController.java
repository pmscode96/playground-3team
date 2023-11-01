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
        ReplyDTO replyDTO = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        if(session.getAttribute("user") != null){
            Optional<FreePostDTO> foundPost = postService.freePostDetail(id, user.getId());
            if(foundPost.isPresent()){
                replyDTO.setPostId(foundPost.get().getId());
                replyDTO.setUserId(user.getId());
                session.setAttribute("post", foundPost.get());
                session.setAttribute("replys", postService.freePostReplyList(replyDTO));
                return new RedirectView("/post/free-post-detail");
            }
        }else{
            return new RedirectView("/login/login");
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
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        postService.freePostReplyInsert(replyDTO);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(replyDTO.getPostId(), user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(replys));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post-detail");
    }

    @PostMapping("/free-post-reply-delete")
    public RedirectView deleteReplyFreePost(Long replyId, Long postId){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");

        postService.freePostReplyLikeDeleteAllByReplyId(replyId);
        postService.freePostReplyDelete(replyId);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(postId, user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(replys));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post-detail");
    }

    @PostMapping("/free-post-reply-update")
    public RedirectView updateReplyFreePost(ReplyVO replyVO, Long postId){
        if(session.getAttribute("user") == null){
            return new RedirectView("/login/login");
        }
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        postService.replyUpdate(replyVO);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(postId, user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(replys));
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
        if(session.getAttribute("user") == null){
            return new RedirectView("/login/login");
        }
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(id, user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.consultingPostReplyList(replys));
            return new RedirectView("/post/consulting-post-detail");
        }
        log.info("못들어옴");
        return new RedirectView("/post/consulting-post");
    }

    @GetMapping("/consulting-post-detail")
    public void goToConsultingPostDetail(ConsultingPostDTO consultingPostDTO){
        UserVO user = (UserVO) session.getAttribute("user");
    }

    @PostMapping("/consulting-post-detail")
    public RedirectView  createConsultingReply(ReplyDTO replyDTO){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        postService.consultingPostReplyInsert(replyDTO);
        Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(replyDTO.getPostId(), user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.consultingPostReplyList(replys));
            return new RedirectView("/post/consulting-post-detail");
        }
        return new RedirectView("/post/consulting-post-detail");
    }

    @PostMapping("/consulting-post-reply-delete")
    public RedirectView deleteReplyConsultingPost(Long replyId, Long postId){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");

        postService.consultingPostReplyLikeDeleteAllByReplyId(replyId);
        postService.consultingPostReplyDelete(replyId);
        Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(postId, user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.consultingPostReplyList(replys));
            return new RedirectView("/post/consulting-post-detail");
        }
        return new RedirectView("/post/consulting-post-detail");
    }

    @PostMapping("/consulting-post-reply-update")
    public RedirectView updateReplyConsultingPost(ReplyVO replyVO, Long postId){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        postService.replyUpdate(replyVO);
        Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(postId, user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.consultingPostReplyList(replys));
            return new RedirectView("/post/consulting-post-detail");
        }
        return new RedirectView("/post/consulting-post-detail");
    }

    @GetMapping("/most-recommended-posts")
    public void goToMostRecommendedPosts(){;}

    @GetMapping("/most-recommended-posts-detail")
    public void goToMostRecommendedPostsDetail(){;}

    @GetMapping("/school-post")
    public void goToSchoolPost(){;}

    @GetMapping("/free-post-write")
    public RedirectView goToFreeWriteForm(){;
        if(session.getAttribute("user") == null){
            return new RedirectView("/login/login");
        }
        return new RedirectView("/post/free-write");
    }

    @GetMapping("/free-write")
    public void goToFreeWrite(){;}

    @PostMapping("/free-write")
    public RedirectView freePostCreate(PostDTO postDTO){
        postDTO.setCategory("free");
        postService.createFreePost(postDTO);
        return new RedirectView("/post/free-post");
    }

    @GetMapping("/consulting-post-write")
    public RedirectView goToConsultingWriteForm(){;
        if(session.getAttribute("user") == null){
            return new RedirectView("/login/login");
        }
        return new RedirectView("/post/consulting-write");
    }

    @GetMapping("/consulting-write")
    public void goToConsultingWrite(){;}

    @PostMapping("/consulting-write")
    public RedirectView consultingPostCreate(PostDTO postDTO){
        postDTO.setCategory("consulting");
        postService.createConsultingPost(postDTO);
        return new RedirectView("/post/consulting-post");
    }

    @GetMapping("/free-update")
    public void goToFreeUpdate(PostDTO postDTO){;}

    @PostMapping("/free-update")
    public RedirectView freeUpdate(PostVO postVO){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        postService.postUpdate(postVO);
        Optional<FreePostDTO> foundPost = postService.freePostDetail(postVO.getId(), user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.freePostReplyList(replys));
            return new RedirectView("/post/free-post-detail");
        }
        return new RedirectView("/post/free-post");
    }

    @GetMapping("/consulting-update")
    public void goToConsultingUpdate(PostDTO postDTO){;}

    @PostMapping("/consulting-update")
    public RedirectView consultingUpdate(PostVO postVO){
        ReplyDTO replys = new ReplyDTO();
        UserVO user = (UserVO) session.getAttribute("user");
        postService.postUpdate(postVO);
        Optional<ConsultingPostDTO> foundPost = postService.consultingPostDetail(postVO.getId(), user.getId());
        if(foundPost.isPresent()){
            replys.setPostId(foundPost.get().getId());
            replys.setUserId(user.getId());
            session.setAttribute("post", foundPost.get());
            session.setAttribute("replys", postService.consultingPostReplyList(replys));
            return new RedirectView("/post/consulting-post-detail");
        }
        return new RedirectView("/post/free-post");
    }

}
