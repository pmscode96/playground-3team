package com.app.playground.repository;

import com.app.playground.domain.VO.AdministratorVO;
import com.app.playground.mapper.AdministratorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.ws.server.endpoint.interceptor.PayloadTransformingInterceptor;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AdministratorDAO {
    private final AdministratorMapper administratorMapper;

//    관리자 가입
    public void saveAdministrator(AdministratorVO administratorVO){administratorMapper.insert(administratorVO);}

//    관리자 조회
    public Optional<AdministratorVO> findByAdministrator(Integer id){return administratorMapper.select(id);}

    public Optional<AdministratorVO> findByAdministratorId(String administratorId){return administratorMapper.selectAdministratorId(administratorId);}

    public Optional<AdministratorVO> findByAdministratorPassword(String administratorPassword){return administratorMapper.selectAdministratorPassword(administratorPassword);}

    public Optional<AdministratorVO> findByAdministratorPasswordCheck(String administratorPasswordCheck){return administratorMapper.selectAdministratorPasswordCheck(administratorPasswordCheck);}

//    관리자 로그인
    public Optional<AdministratorVO> loginAdministrator(AdministratorVO administratorVO){return  administratorMapper.selectLogin(administratorVO);}

//    관리자 삭제
    public void deleteAdministrator(Integer id) {administratorMapper.delete(id);}
}
