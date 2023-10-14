package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultingPostVO {
//    고유번호
    private Long id;

//    제목
    private String consultingPostTitle;

//    내용
    private String consultingPostContent;

//    작성일자
    private LocalDateTime consultingPostCreateDate;


//    좋아요수
    private Integer likeCount;

//    댓글수
    private  Integer replyCount;

    //        생성 날짜
    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    //        ================================ FK
//    회원 테이블 회원 id
//     not null
    private Long userId;

}
