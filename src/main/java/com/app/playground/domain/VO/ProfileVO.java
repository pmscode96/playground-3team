package com.app.playground.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ProfileVO {
//    프로필 고유번호
    private Long id;

//    프로필 명
    private String profileName;

//    프로필 내용
    private String profileContent;

//    프로필 이미지 경로
    private String profileImagesPath;

//    카카오 프로필 이미지 경로
    private String profileKakaoImagePath;

    //        생성 날짜
    private LocalDateTime createDate;
    //        업데이트 날짜
//     삭제 후 재생성이 디폴트이므로 업데이트타임은 필요없음
    private LocalDateTime updateDate;

    //        ================================ FK
//    회원 테이블 회원 id
//     not null

    private Long userId;

}
