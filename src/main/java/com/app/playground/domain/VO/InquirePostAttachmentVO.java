package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class InquirePostAttachmentVO {
//    고유번호
    private Long id;

//    첨부파일명
    private String attachmentName;

//    첨부파일내용
    private String attachmentContent;

//    첨부파일 경로
    private String attachmentPath;

//    첨부파일 올린 날짜
    private LocalDateTime attachmentCreateDate;

//     생성 날짜
    private LocalDateTime createDate;
//     업데이트 날짜

    private LocalDateTime updateDate;

    //        ================================ FK
    private Long inquirePostId;

}
