package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class UserVO {
//    유저 고유번호
//    not null
    private Long id;

//    유저 이름
//    not null
    private String userName;

//    유저 이메일
//    not null
    private String userEmail;

//    유저 비밀번호
//    not null
    private String userPassword;

//    유저 전화번호
//    not null
    private String userPhone;

//    유저 학교
//    not null
    private String userSchool;

//    유저 구분
//    not null
    private Integer userDivision;

//    유저 직위

//    유저 SNS구분
    private  Integer userSns;

//    담임교사 여부
    private Integer teacherExsit;

//    성별
    private Integer userGender;

//    나이
    private Integer userAge;

//        생성 날짜
    private LocalDateTime createDate;
//        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;
}
