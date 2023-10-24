package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@Data
public class UserVO implements Serializable {
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
    private Integer userPosition;

//    유저 SNS구분
    private  Integer userSns;

//    담임교사 여부
    private Integer teacherExsit;

//    성별
    private String userGender;

//    나이
    private Integer userAge;

//        생성 날짜
    private LocalDateTime createDate;
//        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    private String userProfileName;

    private String userProfilePath;

    private boolean userStatus;

    private String userLoginCode;

    private String userKakaoEmail;

    private String userKakaoProfileUrl;

    private String userPasswordCheck;

    //    SNS 로그인상태
//    기본 값 : 0
//    옵션 : 0 - 미사용, 1 - 카카오 로그인
    private Integer userSnsLoginStatus;

    //  회원 프로필
//  not null
    private  String userProfile;

    private String userNickname;
}
