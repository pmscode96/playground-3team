package com.app.playground.service;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
//    회원가입
    @Override
    public void join(UserVO userVO, Long id) {
//        1. 일반회원, 카카오회원 구분
        if(userVO.getUserKakaoProfileUrl() != null){// 카카오 로그인
            Optional<UserVO> foundUser = getKakaoUser(userVO.getUserKakaoEmail());
            if(id != null){
                userVO.setId(id);
                delete(foundUser.get().getId());
                synchronize(userVO);
                return;
            }

//            1-2. 최초 로그인 검사
            if(foundUser.isEmpty()){ // 이메일 정보가 없을 경우
                userDAO.save(userVO);
            }else{ // 이메일 정보가 있을 경우
                UserVO user =  foundUser.get();
//              1-3. 카카오회원일 경우 프사 검사
                if(user.getUserProfileName() == null){ // 프로필 경로가 null -> 전달받은 프사경로로 수정
//                    전달받은 카카오 프사로 업데이트
                    updateKakoProfile(userVO);
                }
            }
        }else {
            userVO.setUserLoginCode("NORMAL");
            userVO.setUserSnsLoginStatus(0);
            userDAO.save(userVO);
        }
    }

    @Override
    public Optional<UserVO> login(UserVO userVO) {
        return userDAO.login(userVO);
    }

    //    회원 정보 조회
    @Override
    public Optional<UserVO> getUser(String userEmail) {
        return userDAO.findByUserEmail(userEmail);
    }

//    카카오 회원 조회
    @Override
    public Optional<UserVO> getKakaoUser(String userKakaoEmail) {
        return userDAO.findByUserKakaoEmail(userKakaoEmail);
    }

    @Override
    public Optional<UserVO> getUserById(Long id) {
        return userDAO.findByUserId(id);
    }


    //    카카오 프사 수정
    @Override
    public void updateKakoProfile(UserVO userVO) {
        userDAO.setKakoProfile(userVO);
    }

    @Override
    public void synchronize(UserVO userVO) {
        userDAO.updateBySync(userVO);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Override
    public void updateInfo(UserVO userVO) {
        userDAO.updateInfo(userVO);
    }

    @Override
    public boolean userPhone(String phoneNumber) {
        String phone = userDAO.findUserPhone(phoneNumber);
        return phone != null;
    }

    @Override
    public void updateUserPhone(UserVO userVO) {
        userDAO.updateUserPhone(userVO);
    }

    @Override
    public void updateUser(UserVO userVO) {
        userDAO.updateUser(userVO);
    }

    @Override
    public Optional<UserVO> findId(UserVO userVO) {
        return userDAO.findId(userVO);
    }

    @Override
    public Long findPw(UserVO userVO) {
        return userDAO.findPw(userVO);
    }

    @Override
    public void updatePw(UserVO userVO) {
        userDAO.updatePw(userVO);
    }
}
