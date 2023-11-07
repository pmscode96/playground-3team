package com.app.playground.mapper;


import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MainMapper {
//    베스트 댓글
    public Optional<ReplyDTO> selectBestReply();

//    게시글 총 갯수
    public int selectPostCount();

//    게시글 5개 랜덤 리스트
    public List<PostDTO> randomList();
}
