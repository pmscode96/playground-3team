package com.app.playground.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ReplyDTO {
    //    고유번호
    private Long id;

    private Long postId;

    //    댓글내용
    private String replyContent;

    //    생성날짜
    private LocalDateTime createDate;

    //    업데이트 날짜
    private LocalDateTime updateDate;

//    유저아이디
    private Long userId;

    private String userName;

    private String userNickname;

//    좋아요 카운트
    private Integer likeCount;

    private Long replyLikeId;

    private String userSchool;

    private String userKakaoProfileUrl;

}
