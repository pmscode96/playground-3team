package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class PostVO {
//    고유번호
    private Long id;

//    게시물 제목
    private String postTitle;

//    게시물 내용
    private String postContent;

//    카테고리
    private String category;

//    생성날짜
    private LocalDateTime createDate;

//    업데이트 날짜
    private LocalDateTime updateDate;
}
