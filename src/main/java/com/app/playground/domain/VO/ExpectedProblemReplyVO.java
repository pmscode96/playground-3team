package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ExpectedProblemReplyVO {
//    고유번호
    private Long id;

//    댓글내용
    private String expectedProblemReplyContent;

//    작성시간
    private LocalDateTime expectedProblemReplyCreateDate;

    //   좋아요 수
    private Integer expectedProblemReplyLikeCount;


    //        생성 날짜
    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    //        ================================ FK
//    예상문제 고유번호 id
//     not null
    private Long expectedProblemId;

}
