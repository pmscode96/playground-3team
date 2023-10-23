package com.app.playground.main;

import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.mapper.MainMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private MainMapper mainMapper;

    @Test
    public void selectBestReplyTest(){
        Optional<ReplyDTO> foundReply = mainMapper.selectBestReply();
        log.info(String.valueOf(foundReply));
    }



}
