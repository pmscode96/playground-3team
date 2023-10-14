package com.app.playground.service;

import com.app.playground.domain.VO.AdministratorVO;
import com.app.playground.repository.AdministratorDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorDAO administratorDAO;

//    관리자 회원가입
    @Override
    public void joinAdministrator(AdministratorVO administratorVO, Integer id) {
        Optional<AdministratorVO> foundAdministrator = getAdministrator(Integer.valueOf(administratorVO.getAdministratorId()));
//            최초 로그인 검사
       if(foundAdministrator.isEmpty()){ //아이디가 존재할 경우
           AdministratorVO administrator = foundAdministrator.get(); //정보를 가져와라!
       }else {
           administratorDAO.saveAdministrator(administratorVO);
       }
    }

//    관리자 조회
    @Override
    public Optional<AdministratorVO> getAdministrator(Integer id) {
        return administratorDAO.findByAdministrator(id);
    }

//    관리자 로그인
    @Override
    public Optional<AdministratorVO> loginAdministrator(AdministratorVO administratorVO) {
        return administratorDAO.loginAdministrator(administratorVO);
    }

//    관리자 삭제
    @Override
    public void deleteAdministrator(Integer id) {
        administratorDAO.deleteAdministrator(id);
    }
}
