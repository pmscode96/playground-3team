package com.app.playground.freePost;

import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.mapper.FreePostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private FreePostMapper freePostMapper;

    @Test
    public void freePostInsertTest(){
        FreePostVO freePostVO =new FreePostVO();
        freePostVO.setFreePostTitle("테스트 제목 1번");
        freePostVO.setFreePostContent("테스트 내용 1번");
        freePostVO.setUserId(1L);

        freePostMapper.insert(freePostVO);
    }
}
