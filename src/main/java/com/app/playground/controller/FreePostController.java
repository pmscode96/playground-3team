package com.app.playground.controller;


import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.VO.FreePostLikeVO;
import com.app.playground.domain.VO.FreePostReplyLikeVO;
import com.app.playground.service.InquirePostService;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FreePostController {
    public final InquirePostService inquirePostService;
    private final PostService postService;
    private final HttpSession session;

    @PostMapping("reply/free-post-reply")
    public ReplyDTO createReply(ReplyDTO replyDTO) {
        postService.freePostReplyInsert(replyDTO);
        return replyDTO;
    }

    @GetMapping("reply/free-post-reply-like")
    public ReplyDTO freeReplyLike(FreePostReplyLikeVO freePostReplyLikeVO){


        // 해당 댓글에 현재 로그인된 userId로 생성된 좋아요가 있는지 확인;
        Optional<FreePostReplyLikeVO> check = postService.freePostReplyLikeSelect(freePostReplyLikeVO);

        FreePostDTO post = (FreePostDTO) session.getAttribute("post");

//        새로운 댓글 DTO객체 생성
        ReplyDTO replyDTO = new ReplyDTO();
//        받아온 댓글ID, 유저ID 담아주기
        replyDTO.setId(freePostReplyLikeVO.getReplyId());
        replyDTO.setUserId(freePostReplyLikeVO.getUserId());

        Optional<ReplyDTO> reply;

        // 코드 작성
        if(check.isPresent()){
            freePostReplyLikeVO.setId(check.get().getId());
            freePostReplyLikeVO.setStatus(check.get().getStatus());
            // 좋아요가 생성된적 있을경우 status 0일경우 좋아요 누른상태 1일경우 좋아요 안한상태(취소)
            if(freePostReplyLikeVO.getStatus().equals(0)){ // 좋아요 취소
                log.info("좋아요 취소");
                freePostReplyLikeVO.setStatus(1);
                postService.freePostReplyLikeStatusUpdate(freePostReplyLikeVO);
                reply = postService.freeReplySelect(replyDTO);
                return reply.orElse(new ReplyDTO());
            }else{
                log.info("좋아요");// 다시 좋아요 상태로 변경
                freePostReplyLikeVO.setStatus(0);
                postService.freePostReplyLikeStatusUpdate(freePostReplyLikeVO);
                reply = postService.freeReplySelect(replyDTO);
                return reply.orElse(new ReplyDTO());
            }
        }else { // 해당 댓글에 좋아요를 한번도 누른적이 없을 경우 좋아요 생성 default값 0
            log.info("좋아요 생성");
            postService.freePostReplyLike(freePostReplyLikeVO);
            reply = postService.freeReplySelect(replyDTO);
            return reply.orElse(new ReplyDTO());
        }
    }

    @GetMapping("post/free-post-like")
    public FreePostDTO freePostLike(FreePostLikeVO freePostLikeVO){
        log.info("들어옴");
        log.info(freePostLikeVO.toString());

        // 해당 댓글에 현재 로그인된 userId로 생성된 좋아요가 있는지 확인;
        Optional<FreePostLikeVO> check = postService.freePostLikeSelect(freePostLikeVO);

        FreePostDTO freePostDTO = new FreePostDTO();
        freePostDTO.setId(freePostLikeVO.getPostId());
        freePostDTO.setUserId(freePostLikeVO.getUserId());
        Optional<FreePostDTO> post;
        // 코드 작성
        if(check.isPresent()){
            freePostLikeVO.setId(check.get().getId());
            freePostLikeVO.setStatus(check.get().getStatus());
            // 좋아요가 생성된적 있을경우 status 0일경우 좋아요 누른상태 1일경우 좋아요 안한상태(취소)
            if(freePostLikeVO.getStatus().equals(0)){ // 좋아요 취소
                log.info("좋아요 취소");
                freePostLikeVO.setStatus(1);
                postService.freePostLikeStatusUpdate(freePostLikeVO);
                post = postService.freePostDetail(freePostDTO.getId(),freePostLikeVO.getUserId());
                return post.orElse(new FreePostDTO());
            }else{
                log.info("좋아요");// 다시 좋아요 상태로 변경
                freePostLikeVO.setStatus(0);
                postService.freePostLikeStatusUpdate(freePostLikeVO);
                post = postService.freePostDetail(freePostDTO.getId(),freePostLikeVO.getUserId());
                return post.orElse(new FreePostDTO());
            }
        }else { // 해당 댓글에 좋아요를 한번도 누른적이 없을 경우 좋아요 생성 default값 0
            log.info("좋아요 생성");
            postService.freePostLike(freePostLikeVO);
            post = postService.freePostDetail(freePostDTO.getId(),freePostLikeVO.getUserId());
            return post.orElse(new FreePostDTO());
        }
    }
}
