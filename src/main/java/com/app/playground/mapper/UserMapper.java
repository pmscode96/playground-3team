package com.app.playground.mapper;


import com.app.playground.domain.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
//    회원가입
    public void insert(UserVO userVO);

//    로그인
    public Optional<UserVO> selectByLogin(UserVO userVO);

//    회원 정보 조회
    public Optional<UserVO> select(String userEmail);

    //    카카오회원 정보 조회
    public Optional<UserVO> selectKakao(String userKakaoEmail);

//    회원 아이디로 조회
    public Optional<UserVO> selectUser(Long id);

//    카카오 프사 수정
    public void updateKakoProfile(UserVO userVO);

//    연동하기
    public void updateBySync(UserVO userVO);

//    회원 삭제
    public void delete(Long id);

//    카카오 회원 정보 추가
    public void updateInfo(UserVO userVO);

//    핸드폰번호 있는지 조회
    public String selectPhone(String userPhone);

//    핸드폰번호 업데이트
    public void updateUserPhone(UserVO userVO);

//    유저 정보 업데이트
    public void updateUser(UserVO userVO);

//  유저 아이디 찾기
    public Optional<UserVO> findId(UserVO userVO);

//    유저 비밀번호 찾기
    public Long findPw(UserVO userVO);

//    비밀번호 변경
    public void updatePw(UserVO userVO);

}
