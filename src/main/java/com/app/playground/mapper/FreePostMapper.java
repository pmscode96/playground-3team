package com.app.playground.mapper;


import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FreePostMapper {
//    게시물 작성
    public void insert(FreePostVO freePostVO);

//    게시물 상세보기
    public Optional<FreePostVO> select(Long id);

//    게시물 전체 리스트(페이징처리)
    public List<FreePostVO> selectAll(@Param("pagination") Pagination pagination, @Param("Search") Search Search, @Param("keyword") String keyword);

//    게시물 list 총 개수
    public int selectTotal(Search Search);

//    게시물 목록
    public List<FreePostVO> selectSearch(Search search);

//    다음 게시물 id
    public Integer nextPost(Integer id);

//    이전 게시물 id
    public Integer prevPost(Integer id);

//    게시물 수정
    public void update(FreePostVO freePostVO);

//    좋아요 증가
    public void likeCountUp(Long id);

//    좋아요 감소
    public void likeCountDown(Long id);

//    댓글 달기
    public void replyInsert(FreePostReplyVO freePostReplyVO);

//    댓글 카운트 증가
    public void replyCountUp(Long freePostId);

//    댓글 카운트 감소
    public void replyCountDown(Long freePostId);

//    댓글 수정
    public void replyUpdate(FreePostReplyVO freePostReplyVO);

//    댓글 삭제
    public void replyDelete(Long id);

//    댓글 좋아요 증가
    public void replyLikeCountUp(Long id);

//    댓글 좋아요 감소
    public void replyLikeCountDown(Long id);
}
