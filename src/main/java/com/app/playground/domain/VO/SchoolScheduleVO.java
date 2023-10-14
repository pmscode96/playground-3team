package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SchoolScheduleVO {
    private Long id;

    private String schoolScheduleTitle;

    private String schoolScheduleContent;

    private LocalDateTime schoolScheduleCreateDate;

    private Integer viewCount;

    private LocalDateTime schoolScheduleStartDate;

    private LocalDateTime schoolScheduleEndDate;

    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    private Long administratorId;

    private Long schoolId;

    private Long schoolScheduleAttachmentId;

}
