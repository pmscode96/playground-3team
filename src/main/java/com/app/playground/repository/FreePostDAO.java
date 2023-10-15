package com.app.playground.repository;


import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.mapper.FreePostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FreePostDAO {
    private final FreePostMapper freePostMapper;

//    게시물 작성
    public void save(FreePostVO freePostVO){freePostMapper.insert(freePostVO);}

//    게시물 상세보기
    public Optional<FreePostVO> selectByPostId(Long id){return freePostMapper.select(id);}

//    게시물 전체 리스트
    public List<FreePostVO> list(Pagination pagination, Search Search, String keyword){return freePostMapper.selectAll(pagination, Search, keyword);}

//    게시물 리스트 카운트
    public int selectTotal(Search search){ return freePostMapper.selectTotal(search);}

//    게시물 검색
    public List<FreePostVO> selectSearch(Search search){return freePostMapper.selectSearch(search);}

//    다음 게시물 id
    public Integer nextPost(Integer id){return freePostMapper.nextPost(id);}

//    이전 게시물 id
    public Integer prevPost(Integer id){return freePostMapper.prevPost(id);}

    //    게시물 수정
    public void update(FreePostVO freePostVO){freePostMapper.update(freePostVO);};

    //    좋아요 증가
    public void likeCountUp(Long id){freePostMapper.likeCountUp(id);};

    //    좋아요 감소
    public void likeCountDown(Long id){freePostMapper.likeCountDown(id);};

    //    댓글 달기
    public void replyInsert(FreePostReplyVO freePostReplyVO){freePostMapper.replyInsert(freePostReplyVO);};

    //    댓글 카운트 증가
    public void replyCountUp(Long freePostId){freePostMapper.replyCountUp(freePostId);};

    //    댓글 카운트 감소
    public void replyCountDown(Long freePostId){freePostMapper.replyCountDown(freePostId);};

//    댓글 삭제
    public void replyDelete(Long id){freePostMapper.replyDelete(id);}

    //    댓글 수정
    public void replyUpdate(FreePostReplyVO freePostReplyVO){freePostMapper.replyUpdate(freePostReplyVO);};

    //    댓글 좋아요 증가
    public void replyLikeCountUp(Long id){freePostMapper.replyLikeCountUp(id);}

//    댓글 좋아요 감소
    public void replyLikeCountDown(Long id){freePostMapper.replyLikeCountDown(id);}



}
