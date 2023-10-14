package com.app.playground.mapper;

import com.app.playground.domain.VO.AdministratorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AdministratorMapper {

//    관리자 가입
    public void insertAdministrator(AdministratorVO administratorVO);

//    관리자 조회
    public Optional<AdministratorVO> selectAdministrator(Integer id);

//    관리자 로그인
    public Optional<AdministratorVO> selectAdministratorLogin(AdministratorVO administratorVO);

//    관리자 삭제
    public void deleteAdministrator(Integer id);

}
