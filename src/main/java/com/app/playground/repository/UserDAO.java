package com.app.playground.repository;


import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.mapper.FreePostMapper;
import com.app.playground.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDAO {
    private final UserMapper userMapper;

//    회원가입
    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }

//    회원 정보 조회
    public Optional<UserVO> findByUserEmail(String userEmail){
        return userMapper.select(userEmail);
    };

    //    카카오 프사 수정
    public void setKakoProfile(UserVO userVO){
        userMapper.updateKakoProfile(userVO);
    };


}
