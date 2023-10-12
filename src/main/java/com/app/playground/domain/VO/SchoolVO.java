package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SchoolVO {

//    학교 고유번호
    private Long id;

//    학교명
//    not null
    private String schoolName;

//    학년
    private Integer schoolGrade;

//    반
    private Integer schoolClass;

//    시
    private String schoolCity;

//    지역
    private String schoolArea;

//        생성 날짜
    private LocalDateTime createDate;
//        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

//        ================================ FK
//    회원 테이블 회원 id
//     not null
    private Long userId;

    private Long administratorId;

}
