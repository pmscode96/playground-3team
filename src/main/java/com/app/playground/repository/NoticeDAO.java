package com.app.playground.repository;

import com.app.playground.domain.VO.NoticeVO;
import com.app.playground.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NoticeDAO {
    private final NoticeMapper noticeMapper;

//    게시물 작성
    public void save(NoticeVO noticeVO){noticeMapper.insert(noticeVO);}
}
