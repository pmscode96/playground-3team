package com.app.playground.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class InquirePostDTO {
    //    고유번호
    private Long id;

    //    유저아이디
    private Long userId;

    //    게시물 제목
    private String inquirePostTitle;

    //    게시물 내용
    private String inquirePostContent;

    //    답글
    private String inquirePostAnswer;

    //    생성날짜
    private LocalDateTime createDate;

    //    업데이트 날짜
    private LocalDateTime updateDate;

    //    관리자 아이디
    private Long administratorId;

    private String userName;

    private String userNickname;

    private String userSchool;

    private Integer userDivision;
}
