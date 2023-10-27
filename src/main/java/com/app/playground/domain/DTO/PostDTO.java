package com.app.playground.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@Data
public class PostDTO implements Serializable {
    //    고유번호
    private Long id;

    //    제목
    private String postTitle;

    //    내용
    private String postContent;

//    카테고리
    private String category;

    //        생성 날짜
    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

//    ================================ FK
//    회원 테이블 회원 id
//     not null
    private Long userId;

    private String userName;

    private String userNickname;

    private String userSchool;

    private Integer userDivision;

    private String userKakaoProfileUrl;

    private Integer rownum;
}
