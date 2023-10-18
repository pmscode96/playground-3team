package com.app.playground.repository;


import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.VO.UserVO;
import com.app.playground.mapper.MainMapper;
import com.app.playground.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MainDAO {
    private final MainMapper mainMapper;

    //    베스트 댓글
    public Optional<ReplyDTO> selectBestReply(){return mainMapper.selectBestReply();};

//    게시글 총 갯수
    public int selectPostCount(){return mainMapper.selectPostCount();}

}
