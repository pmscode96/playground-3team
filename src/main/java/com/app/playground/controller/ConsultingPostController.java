package com.app.playground.controller;


import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.VO.ConsultingPostLikeVO;
import com.app.playground.domain.VO.ConsultingPostReplyLikeVO;
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
public class ConsultingPostController {
    public final InquirePostService inquirePostService;
    private final PostService postService;
    private final HttpSession session;

    @PostMapping("reply/consulting-post-reply")
    public ReplyDTO createReply(ReplyDTO replyDTO) {
        postService.consultingPostReplyInsert(replyDTO);
        return replyDTO;
    }

    @GetMapping("reply/consulting-post-reply-like")
    public ReplyDTO consultingReplyLike(ConsultingPostReplyLikeVO consultingPostReplyLikeVO){


        // 해당 댓글에 현재 로그인된 userId로 생성된 좋아요가 있는지 확인;
        Optional<ConsultingPostReplyLikeVO> check = postService.consultingPostReplyLikeSelect(consultingPostReplyLikeVO);
        ConsultingPostDTO post = (ConsultingPostDTO) session.getAttribute("post");

//        새로운 댓글 DTO객체 생성
        ReplyDTO replyDTO = new ReplyDTO();
//        받아온 댓글ID, 유저ID 담아주기
        replyDTO.setId(consultingPostReplyLikeVO.getReplyId());
        replyDTO.setUserId(consultingPostReplyLikeVO.getUserId());

        Optional<ReplyDTO> reply;

        // 코드 작성
        if(check.isPresent()){
            consultingPostReplyLikeVO.setId(check.get().getId());
            consultingPostReplyLikeVO.setStatus(check.get().getStatus());
            // 좋아요가 생성된적 있을경우 status 0일경우 좋아요 누른상태 1일경우 좋아요 안한상태(취소)
            if(consultingPostReplyLikeVO.getStatus().equals(0)){ // 좋아요 취소
                log.info("좋아요 취소");
                consultingPostReplyLikeVO.setStatus(1);
                postService.consultingPostReplyLikeStatusUpdate(consultingPostReplyLikeVO);
                reply = postService.consultingReplySelect(replyDTO);
                return reply.orElse(new ReplyDTO());
            }else{
                log.info("좋아요");// 다시 좋아요 상태로 변경
                consultingPostReplyLikeVO.setStatus(0);
                postService.consultingPostReplyLikeStatusUpdate(consultingPostReplyLikeVO);
                reply = postService.consultingReplySelect(replyDTO);
                return reply.orElse(new ReplyDTO());
            }
        }else { // 해당 댓글에 좋아요를 한번도 누른적이 없을 경우 좋아요 생성 default값 0
            log.info("좋아요 생성");
            postService.consultingPostReplyLike(consultingPostReplyLikeVO);
            reply = postService.consultingReplySelect(replyDTO);
            return reply.orElse(new ReplyDTO());
        }
    }

    @GetMapping("post/consulting-post-like")
    public ConsultingPostDTO consultingPostLike(ConsultingPostLikeVO consultingPostLikeVO){
        log.info("들어옴");
        log.info(consultingPostLikeVO.toString());

        // 해당 댓글에 현재 로그인된 userId로 생성된 좋아요가 있는지 확인;
        Optional<ConsultingPostLikeVO> check = postService.consultingPostLikeSelect(consultingPostLikeVO);

        ConsultingPostDTO consultingPostDTO = new ConsultingPostDTO();
        consultingPostDTO.setId(consultingPostLikeVO.getPostId());
        consultingPostDTO.setUserId(consultingPostLikeVO.getUserId());
        Optional<ConsultingPostDTO> post;
        // 코드 작성
        if(check.isPresent()){
            consultingPostLikeVO.setId(check.get().getId());
            consultingPostLikeVO.setStatus(check.get().getStatus());
            // 좋아요가 생성된적 있을경우 status 0일경우 좋아요 누른상태 1일경우 좋아요 안한상태(취소)
            if(consultingPostLikeVO.getStatus().equals(0)){ // 좋아요 취소
                log.info("좋아요 취소");
                consultingPostLikeVO.setStatus(1);
                postService.consultingPostLikeStatusUpdate(consultingPostLikeVO);
                post = postService.consultingPostDetail(consultingPostDTO.getId(),consultingPostLikeVO.getUserId());
                return post.orElse(new ConsultingPostDTO());
            }else{
                log.info("좋아요");// 다시 좋아요 상태로 변경
                consultingPostLikeVO.setStatus(0);
                postService.consultingPostLikeStatusUpdate(consultingPostLikeVO);
                post = postService.consultingPostDetail(consultingPostDTO.getId(),consultingPostLikeVO.getUserId());
                return post.orElse(new ConsultingPostDTO());
            }
        }else { // 해당 댓글에 좋아요를 한번도 누른적이 없을 경우 좋아요 생성 default값 0
            log.info("좋아요 생성");
            postService.consultingPostLike(consultingPostLikeVO);
            post = postService.consultingPostDetail(consultingPostDTO.getId(),consultingPostLikeVO.getUserId());
            return post.orElse(new ConsultingPostDTO());
        }
    }
}
