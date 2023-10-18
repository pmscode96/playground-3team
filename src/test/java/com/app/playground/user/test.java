package com.app.playground.user;

import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.mapper.FreePostMapper;
import com.app.playground.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class test {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void userInsertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("hong@gamil.com");
        userVO.setUserName("홍길동");
        userVO.setUserPassword("1234");
        userVO.setUserPhone("010-1234-1234");
        userVO.setUserSchool("한국고등학교");
        userVO.setUserLoginCode("nomal");

        userMapper.insert(userVO);

    }

}
