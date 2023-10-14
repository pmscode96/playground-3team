package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SchoolMealVO {
    private Long id;

    private Integer schoolMealDivision;

    private String schoolMealContent;

    private LocalDateTime schoolMealDate;

    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    private Long schoolId;

}
