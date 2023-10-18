package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class AdministratorVO {
//    유저 고유번호
//    not null
    private Integer id;

//    관리자 아이디
//    not null
    private String administratorId;

//    관리자 비밃번호
//    not null
    private String administratorPassword;

//    로그인 시간
//    not null
    private LocalDateTime administratorLoginTime;

//    로그아웃 시간
//    not null
    private LocalDateTime administratorLogoutTime;

//        생성 날짜
    private LocalDateTime createDate;
//        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

//    관리자 패스워드 체크
//    null 허용
    private String administratorPasswordCheck;

//    관리자 이메일
//    null 허용
    private String administratorEmail;
}
