package com.app.playground.mapper;

import com.app.playground.domain.VO.AdministratorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AdministratorMapper {

//    관리자 가입
    public void insert(AdministratorVO administratorVO);

//    관리자 조회
    public Optional<AdministratorVO> select(Integer id);

    public Optional<AdministratorVO> selectAdministratorId(String administratorId);

    public Optional<AdministratorVO> selectAdministratorPassword(String administratorPassword);

    public Optional<AdministratorVO> selectAdministratorPasswordCheck(String administratorPasswordCheck);

//    관리자 로그인
    public Optional<AdministratorVO> selectLogin(AdministratorVO administratorVO);

//    관리자 삭제
    public void delete(Integer id);

}
