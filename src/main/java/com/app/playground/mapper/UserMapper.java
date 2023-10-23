package com.app.playground.mapper;


import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.UserVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

}
