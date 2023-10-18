package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class InquirePostVO {
    //    고유번호
    private Long id;

    //    유저아이디
    private Long userId;
}
