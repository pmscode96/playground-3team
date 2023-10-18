package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FreePostLikeVO {
//    고유번호
    private Long id;

//    게시물 아이디
    private Long postId;

//    유저 아이디
    private Long userId;
}
