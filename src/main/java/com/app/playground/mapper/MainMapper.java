package com.app.playground.mapper;


import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.swing.plaf.PanelUI;
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
