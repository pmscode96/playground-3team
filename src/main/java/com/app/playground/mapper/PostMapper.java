package com.app.playground.mapper;


import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    게시물 작성
    public void insert(PostDTO postDTO);

//    자유게시판 작성
    public void insertFreePost(PostDTO postDTO);

//    고민게시판
    public void insertConsultingPost(PostDTO postDTO);

//    게시물 상세보기 자유게시판
    public Optional<FreePostDTO> selectFreePost(Long id);

//    게시물 상세보기 고민게시판
    public Optional<ConsultingPostDTO> selectConsultingPost(Long id);

//    자유게시판 게시물 전체 리스트(페이징처리)
    public List<FreePostDTO> selectFreePostList(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword);

//    자유게시판 게시물 전체 리스트(페이징처리)
    public List<ConsultingPostDTO> selectConsultingPostList(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword);

//            게시물 list 총 개수
    public int selectTotalFreePost(Search search);

    //            게시물 list 총 개수
    public int selectTotalConsultingPost(Search search);

//    게시물 목록
    public List<FreePostDTO> selectSearchFreePost(Search search);

    //    게시물 목록
    public List<ConsultingPostDTO> selectSearchConsultingPost(Search search);


//    게시물 수정
    public void postUpdate(PostVO postVO);

//    댓글 달기
    public void replyInsert(ReplyVO replyVO);

//    자유게시판 댓글
    public void freePostReplyInsert(FreePostReplyVO freePostReplyVO);

    //    고민게시판 댓글
    public void consultingPostReplyInsert(ConsultingPostReplyVO consultingPostReplyVO);

//    댓글 수정
    public void replyUpdate(ReplyVO replyVO);

//    댓글 삭제
    public void replyDelete(Long id);

//    자유게시판 댓글 삭제
    public void freePostReplyDelete(Long id);

//   고민게시판 댓글 삭제
    public void consultingPostReplyDelete(Long id);

//    자유게시판 댓글 좋아요
    public void freePostReplyLike(FreePostReplyLikeVO freePostReplyLikeVO);

//    자유게시판 댓글 좋아요 취소
    public void freePostReplyLikeDelete(Long id);

//    고민게시판 댓글 좋아요
    public void consultingPostReplyLike(ConsultingPostReplyLikeVO consultingPostReplyLikeVO);

//    고민게시판 댓글 좋아요 취소
    public void consultingPostReplyLikeDelete(Long id);

//    게시글 삭제
    public void postDelete(Long id);

//    자유게시판 게시글 삭제
    public void freePostDelete(Long id);

//    고민게시판 게시글 삭제
    public void consultingPostDelete(Long id);

//    자유게시판 게시글 좋아요
    public void freePostLike(FreePostLikeVO freePostLikeVO);

//    자유게시판 게시글 좋아요 취소
    public void freePostLikeDelete(Long id);

//    고민게시판 게시글 좋아요
    public void consultingPostLike(ConsultingPostLikeVO consultingPostLikeVO);

//    고민게시판 게시글 좋아요 취소
    public void consultingPostLikeDelete(Long id);

//    자유게시판 해당 게시물 댓글 전체 삭제
    public void freePostReplyDeleteAll(Long postId);

//    자유게시판 해당 게시물 댓글 좋아요 전체 삭제
    public void freePostReplyLikeDeleteAll(Long postId);

//    고민게시판 해당 게시물 댓글 전체 삭제
    public void consultingPostReplyDeleteAll(Long postId);

//    고민게시판 해당 게시물 댓글 좋아요 전체 삭제
    public void consultingPostReplyLikeDeleteAll(Long postId);


}
