package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SchoolMealPictureVO {
    private Long id;

    private Integer schoolMealPictureName;

    private String schoolMealPictureContent;

    private String schoolMealPicturePath;

    private LocalDateTime schoolMealPictureDate;

    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    private Long schoolMealId;

}
