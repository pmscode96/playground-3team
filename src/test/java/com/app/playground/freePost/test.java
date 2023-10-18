package com.app.playground.freePost;

import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.NoticeVO;
import com.app.playground.mapper.FreePostMapper;
import com.app.playground.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private FreePostMapper freePostMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    public void freePostInsertTest(){
        FreePostVO freePostVO =new FreePostVO();
        freePostVO.setFreePostTitle("테스트 제목 1번");
        freePostVO.setFreePostContent("테스트 내용 1번");
        freePostVO.setUserId(1L);

        freePostMapper.insert(freePostVO);
    }

    @Test
    public void NoticeInsertTest(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("테스트1");
        noticeVO.setNoticeContent("테스트내용1");
//        noticeVO.setNoticeCreateDate("2023-10-19");
        noticeVO.setAdministratorId(4L);

        noticeMapper.insert(noticeVO);
    }
}
