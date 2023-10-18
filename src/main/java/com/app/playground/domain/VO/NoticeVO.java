package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class NoticeVO {
    private Long id;

    private String noticeTitle;

    private String noticeContent;

    private String noticeDivision;

    private LocalDateTime noticeCreateDate;

//        생성 날짜
    private LocalDateTime createDate;
//        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    private Long administratorId;
}
