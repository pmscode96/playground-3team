package com.app.playground.service;


import com.app.playground.domain.FreePostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;

import java.util.List;
import java.util.Optional;

public interface FreePostService {
//    게시물 작성
    public void create(FreePostVO freePostVO);

//    게시물 상세보기
    public Optional<FreePostVO> detail(Long id);

//    게시물 전체 리스트
    public List<FreePostVO> list(Pagination pagination, Search Search, String keyword);

//    게시물 리스트 카운터
    public int selectTotal(Search search);

//    게시물 검색
    public FreePostSearchDTO searchPost(Search search);

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

//    댓글 삭제
    public void replyDelete(FreePostReplyVO freePostReplyVO);

    //    댓글 수정
    public void replyUpdate(FreePostReplyVO freePostReplyVO);

//    댓글 좋아요 증가
    public void replyLikeCountUp(Long id);

//    댓글 좋아요 감소
    public void replyLikeCountDown(Long id);
}
