package com.app.playground.service;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
//    회원가입
    @Override
    public void join(UserVO userVO) {
//        1. 일반회원, 카카오회원 구분
        if(userVO.getUserProfileName() != null){// 카카오 로그인
            Optional<UserVO> foundUser = getUser(userVO.getUserEmail());
//            1-2. 최초 로그인 검사
            if(foundUser.isEmpty()){ // 이메일 정보가 없을 경우
                userDAO.save(userVO);
            }else{ // 이메일 정보가 있을 경우
                UserVO user =  foundUser.get();
//              1-3. 카카오회원일 경우 프사 검사
                if(user.getUserProfilePath() == null){ // 프로필 경로가 null -> 전달받은 프사경로로 수정
//                    전달받은 카카오 프사로 업데이트
                    updateKakoProfile(userVO);
                }
            }
        }else {
            userDAO.save(userVO);
        }
    }

//    회원 정보 조회
    @Override
    public Optional<UserVO> getUser(String userEmail) {
        return userDAO.findByUserEmail(userEmail);
    }

//    카카오 프사 수정
    @Override
    public void updateKakoProfile(UserVO userVO) {
        userDAO.setKakoProfile(userVO);
    }

}
