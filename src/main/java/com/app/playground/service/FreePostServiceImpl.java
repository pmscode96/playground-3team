package com.app.playground.service;

import com.app.playground.domain.FreePostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyVO;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.repository.FreePostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FreePostServiceImpl implements FreePostService {
    private final FreePostDAO freePostDAO;
//    게시물 작성
    @Override
    public void create(FreePostVO freePostVO) {freePostDAO.save(freePostVO);}

    @Override
    public Optional<FreePostVO> detail(Long id) {
        return freePostDAO.selectByPostId(id);
    }

    //    게시물 전체 리스트
    @Override
    public List<FreePostVO> list(Pagination pagination, Search Search, String keyword) {
        return freePostDAO.list(pagination, Search, keyword);
    }

//    게시물 리스트 count
    @Override
    public int selectTotal(Search search) {
        return freePostDAO.selectTotal(search);
    }

//    게시물 검색
    @Override
    public FreePostSearchDTO searchPost(Search search) {
        FreePostSearchDTO freePostSearchDTO = new FreePostSearchDTO();
        freePostSearchDTO.setFreePosts(freePostDAO.selectSearch(search));
        freePostSearchDTO.setFreePostsTotalCount(freePostDAO.selectTotal(search));
        return freePostSearchDTO;
    }

//    다음 게시물 id
    @Override
    public Integer nextPost(Integer id) {
        return freePostDAO.nextPost(id);
    }

//    이전 게시물 id
    @Override
    public Integer prevPost(Integer id) {
        return freePostDAO.prevPost(id);
    }

//    게시물 수정
    @Override
    public void update(FreePostVO freePostVO) {
        freePostDAO.update(freePostVO);
    }

//    게시물 좋아요 증가
    @Override
    public void likeCountUp(Long id) {
        freePostDAO.likeCountUp(id);
    }

//    게시물 좋아요 감소
    @Override
    public void likeCountDown(Long id) {
        freePostDAO.likeCountDown(id);
    }

//    게시물 댓글 추가
    @Override
    public void replyInsert(FreePostReplyVO freePostReplyVO) {
        freePostDAO.replyInsert(freePostReplyVO);
        freePostDAO.replyCountUp(freePostReplyVO.getFreePostId());
    }

//    댓글 삭제
    @Override
    public void replyDelete(FreePostReplyVO freePostReplyVO) {
        freePostDAO.replyDelete(freePostReplyVO.getId());
        freePostDAO.replyCountDown(freePostReplyVO.getFreePostId());
    }

    //    게시물 댓글 수정
    @Override
    public void replyUpdate(FreePostReplyVO freePostReplyVO) {
        freePostDAO.replyUpdate(freePostReplyVO);
    }

//    댓글 좋아요 증가
    @Override
    public void replyLikeCountUp(Long id) {
        freePostDAO.replyLikeCountUp(id);
    }

//    댓글 좋아요 감소
    @Override
    public void replyLikeCountDown(Long id) {
        freePostDAO.replyLikeCountDown(id);
    }



}
