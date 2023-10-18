package com.app.playground.freePost;

import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.mapper.FreePostMapper;
import com.app.playground.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Random;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private FreePostMapper freePostMapper;

    @Test
    public void postSelectTest(){
        freePostMapper.select(41L).stream().map(FreePostVO::toString).forEach(log::info);
    }



}
