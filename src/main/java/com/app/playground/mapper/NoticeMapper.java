package com.app.playground.mapper;

import com.app.playground.domain.VO.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
//    공지사항 작성
    public void insert(NoticeVO noticeVO);

//    공지사항 수정

//    공지사항 조회

//    공지사항 삭제

}
