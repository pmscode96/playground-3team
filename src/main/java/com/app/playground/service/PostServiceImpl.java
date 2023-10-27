package com.app.playground.service;

import com.app.playground.domain.*;
import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.VO.*;
import com.app.playground.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

//    자유게시판 작성
    @Override
    public void createFreePost(PostDTO postDTO) {
        postDAO.save(postDTO);
        postDAO.saveFreePost(postDTO);
    }

//    고민게시판 작성
    @Override
    public void createConsultingPost(PostDTO postDTO) {
        postDAO.save(postDTO);
        postDAO.saveConsultingPost(postDTO);
    }

//    자유게시판 상세보기
    @Override
    public Optional<FreePostDTO> freePostDetail(Long id) {
        return postDAO.selectByFreePostId(id);
    }

//    고민게시판 상세보기
    @Override
    public Optional<ConsultingPostDTO> consultingPostDetail(Long id) {
        return postDAO.selectByConsultingPostId(id);
    }

//    자유게시판 리스트
    @Override
    public List<FreePostDTO> freePostList(Pagination pagination, Search search, String keyword, Long userId) {
        return postDAO.selectFreePostList(pagination, search, keyword, userId);
    }

//    고민게시판 리스트
    @Override
    public List<ConsultingPostDTO> consultingPostList(Pagination pagination, Search search, String keyword, Long userId) {
        return postDAO.selectConsultingPostList(pagination, search, keyword, userId);
    }

    @Override
    public int selectTotalFreePost(Search search) {
        return postDAO.selectTotalFreePost(search);
    }

    @Override
    public int selectTotalConsultingPost(Search search) {
        return postDAO.selectTotalConsultingPost(search);
    }


//    게시물 검색
    @Override
    public PostSearchDTO searchPost(Search search) {
        PostSearchDTO postSearchDTO = new PostSearchDTO();
        postSearchDTO.setFreePosts(postDAO.selectSearchFreePost(search));
        postSearchDTO.setConsultingPosts(postDAO.selectSearchConsultingPost(search));
        postSearchDTO.setPostsTotalCount(postDAO.selectTotalFreePost(search) + postDAO.selectTotalConsultingPost(search));
        return postSearchDTO;
    }

    @Override
    public FreePostSearchDTO searchFreePost(Search search) {
        FreePostSearchDTO freePostSearchDTO = new FreePostSearchDTO();
        freePostSearchDTO.setFreePosts(postDAO.selectSearchFreePost(search));
        freePostSearchDTO.setPostsTotalCount(postDAO.selectTotalFreePost(search));
        return freePostSearchDTO;
    }

    @Override
    public ConsultingPostSearchDTO searchConsultingPost(Search search) {
        ConsultingPostSearchDTO consultingPostSearchDTO = new ConsultingPostSearchDTO();
        consultingPostSearchDTO.setConsultingPosts(postDAO.selectSearchConsultingPost(search));
        consultingPostSearchDTO.setPostsTotalCount(postDAO.selectTotalConsultingPost(search));
        return consultingPostSearchDTO;
    }

//    게시물 수정
    @Override
    public void postUpdate(PostVO postVO) {
        postDAO.postUpdate(postVO);
    }


    @Override
    public void freePostReplyInsert(ReplyDTO replyDTO) {
        postDAO.replyInsert(replyDTO);
        postDAO.freePostReplyInsert(replyDTO);
    }

    @Override
    public void consultingPostReplyInsert(ReplyDTO replyDTO) {
        postDAO.replyInsert(replyDTO);
        postDAO.consultingPostReplyInsert(replyDTO);
    }

    @Override
    public List<ReplyDTO> freePostReplyList(Long postId) {
        return postDAO.freePostReplyList(postId);
    }

    @Override
    public List<ReplyDTO> consultingPostReplyList(Long postId) {
        return postDAO.consultingPostReplyList(postId);
    }

    //    게시물 댓글 수정
    @Override
    public void replyUpdate(ReplyVO replyVO) {
        postDAO.replyUpdate(replyVO);
    }

//    댓글 삭제
    @Override
    public void replyDelete(Long id) {
        postDAO.replyDelete(id);
    }

//    자유게시판 댓글 삭제
    @Override
    public void freePostReplyDelete(Long id) {
        postDAO.freePostReplyDelete(id);
    }

//    고민게시판 댓글 삭제
    @Override
    public void consultingPostReplyDelete(Long id) {
        postDAO.consultingPostReplyDelete(id);
    }

//    자유게시판 좋아요
    @Override
    public void freePostReplyLike(FreePostReplyLikeVO freePostReplyLikeVO) {
        postDAO.freePostReplyLike(freePostReplyLikeVO);
    }

//    자유게시판 좋아요 취소
    @Override
    public void freePostReplyLikeDelete(Long id) {
        postDAO.freePostReplyLikeDelete(id);
    }

//    고민게시판 댓글 좋아요
    @Override
    public void consultingPostReplyLike(ConsultingPostReplyLikeVO consultingPostReplyLikeVO) {
        postDAO.consultingPostReplyLike(consultingPostReplyLikeVO);
    }

//    고민게시판 댓글 좋아요 취소
    @Override
    public void consultingPostReplyLikeDelete(Long id) {
        postDAO.consultingPostReplyLikeDelete(id);
    }

//    자유게시판 게시글 삭제
    @Override
    public void freePostDelete(Long id) {
        postDAO.freePostReplyLikeDeleteAll(id);
        postDAO.freePostReplyDeleteAll(id);
        postDAO.freePostLikeDelete(id);
        postDAO.freePostDelete(id);
    }

//    고민게시판 게시글 삭제
    @Override
    public void consultingPostDelete(Long id) {
        postDAO.consultingPostReplyLikeDeleteAll(id);
        postDAO.consultingPostReplyDeleteAll(id);
        postDAO.consultingPostLikeDelete(id);
        postDAO.consultingPostDelete(id);
    }

//    자유게시판 게시글 좋아요
    @Override
    public void freePostLike(FreePostLikeVO freePostLikeVO) {
        postDAO.freePostLike(freePostLikeVO);
    }

//    자유게시판 게시글 좋아요 취소
    @Override
    public void freePostLikeDelete(Long id) {
        postDAO.freePostLikeDelete(id);
    }

//    고민게시판 게시글 좋아요
    @Override
    public void consultingPostLike(ConsultingPostLikeVO consultingPostLikeVO) {
        postDAO.consultingPostLike(consultingPostLikeVO);
    }

//    고민게시판 게시글 좋아요 취소
    @Override
    public void consultingPostLikeDelete(Long id) {
        postDAO.consultingPostLikeDelete(id);
    }

//    자유게시판 해당 게시글 댓글 전체 삭제
    @Override
    public void freePostReplyDeleteAll(Long postId) {
        postDAO.freePostReplyDeleteAll(postId);
    }

//    자유게시판 해당 게시글 댓글 좋아요 전체 삭제
    @Override
    public void freePostReplyLikeDeleteAll(Long postId) {
        postDAO.freePostReplyLikeDeleteAll(postId);
    }

//    고민게시판 해당 게시글 댓글 전체 삭제
    @Override
    public void consultingPostReplyDeleteAll(Long postId) {
        postDAO.consultingPostReplyDeleteAll(postId);
    }

//    고민게시판 해당 게시글 댓글 좋아요 전체 삭제
    @Override
    public void consultingPostReplyLikeDeleteAll(Long postId) {
        postDAO.consultingPostReplyLikeDeleteAll(postId);
    }

    @Override
    public void freePostReplyLikeDeleteAllByReplyId(Long replyId) {
        postDAO.freePostReplyLikeDeleteAllByReplyId(replyId);
    }

    @Override
    public void consultingPostReplyLikeDeleteAllByReplyId(Long replyId) {
        postDAO.consultingPostReplyLikeDeleteAllByReplyId(replyId);
    }
}
