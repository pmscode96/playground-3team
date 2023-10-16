package com.app.playground.service;

import com.app.playground.domain.VO.UserVO;

import java.util.Optional;

public interface UserService {
//    회원가입
    public void join(UserVO userVO);

//    회원 정보 조회
    public Optional<UserVO> getUser(String userEmail);

    //    카카오 프사 수정
    public void updateKakoProfile(UserVO userVO);
}
