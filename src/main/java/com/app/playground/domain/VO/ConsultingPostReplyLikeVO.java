package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsultingPostReplyLikeVO {
//    고유번호
    private Long id;

//    게시물 아이디
    private Long replyId;

//    유저 아이디
    private Long userId;

//    좋아요 상태
    private Integer status;
}
