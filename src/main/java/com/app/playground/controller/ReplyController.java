package com.app.playground.controller;


import com.app.playground.domain.*;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.VO.FreePostReplyLikeVO;
import com.app.playground.domain.VO.PostVO;
import com.app.playground.service.InquirePostService;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReplyController {
    public final InquirePostService inquirePostService;
    private final PostService postService;
    private final HttpSession session;

    @PostMapping("reply/free-post-reply")
    public ReplyDTO createReply(ReplyDTO replyDTO) {
        postService.freePostReplyInsert(replyDTO);
        return replyDTO;
    }

    @PostMapping("reply/free-post-reply-like")
    public void  freeReplyLike(FreePostReplyLikeVO freePostReplyLikeVO){
        postService.freePostReplyLike(freePostReplyLikeVO);
    }

    @PostMapping("reply/free-post-reply-like-cancel")
    public void  freeReplyLikeCancel(Long replyLikeId){
        postService.freePostReplyLikeDelete(replyLikeId);
    }





}
