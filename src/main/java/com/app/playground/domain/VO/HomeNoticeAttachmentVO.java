package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class HomeNoticeAttachmentVO {
    private Long id;

    private String homeNoticeAttachmentName;

    private String homeNoticeAttachmentContent;

    private String homeNoticeAttachmentPath;

    private LocalDateTime homeNoticeAttachmentDate;

    private Integer homeNoticeAttachmentDownloadCount;

    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

}
