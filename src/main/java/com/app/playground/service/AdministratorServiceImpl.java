package com.app.playground.service;

import com.app.playground.domain.VO.AdministratorVO;
import com.app.playground.repository.AdministratorDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.plaf.PanelUI;
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
//        가입
        administratorDAO.saveAdministrator(administratorVO);
    }

//    관리자 조회
    @Override
    public Optional<AdministratorVO> getAdministrator(Integer id) {
        return administratorDAO.findByAdministrator(id);
    }

    @Override
    public Optional<AdministratorVO> getAdministratorId(String administratorId){
        return administratorDAO.findByAdministratorId(administratorId);
    }

    @Override
    public Optional<AdministratorVO> getAdministratorPassword(String administratorPassword){
        return administratorDAO.findByAdministratorPassword(administratorPassword);
    }

    @Override
    public Optional<AdministratorVO> getAdministratorPasswordCheck(String administratorPasswordCheck){
        return administratorDAO.findByAdministratorPasswordCheck(administratorPasswordCheck);
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
