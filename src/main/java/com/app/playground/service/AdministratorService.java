package com.app.playground.service;

import com.app.playground.domain.VO.AdministratorVO;
import com.app.playground.mapper.AdministratorMapper;

import java.util.Optional;

public interface AdministratorService {

    //    관리자 가입
    public void joinAdministrator(AdministratorVO administratorVO, Integer id);

    public Optional<AdministratorVO> getAdministratorId(String administratorId);

    public Optional<AdministratorVO> getAdministratorPassword(String administratorPassword);

    public Optional<AdministratorVO> getAdministratorPasswordCheck(String administratorPasswordCheck);

    //    관리자 조회
    public Optional<AdministratorVO> getAdministrator(Integer id);

    //    관리자 로그인
    public Optional<AdministratorVO> loginAdministrator(AdministratorVO administratorVO);

    //    관리자 삭제
    public void deleteAdministrator(Integer id);
}
