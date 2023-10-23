package com.app.playground.service;


import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.PostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    자유게시판 작성
    public void createFreePost(PostDTO postDTO);

//    고민게시판 작성
    public void createConsultingPost(PostDTO postDTO);

//    게시물 상세보기
    public Optional<FreePostDTO> freePostDetail(Long id);

//    게시물 상세보기
    public Optional<ConsultingPostDTO> consultingPostDetail(Long id);

//    자유게시판 게시물 전체 리스트(페이징처리)
    public List<FreePostDTO> freePostList(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword);

//    자유게시판 게시물 전체 리스트(페이징처리)
    public List<ConsultingPostDTO> consultingPostList(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword);

//    게시물 list 총 개수
    public int selectTotalFreePost(Search Search);

//    게시물 list 총 개수
    public int selectTotalConsultingPost(Search Search);

//    게시물 검색
    public PostSearchDTO searchPost(Search search);

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

    //    자유게시판 게시글 삭제
    public void freePostDelete(Long id);

    //    고민게시판 게시글 삭제
    public void consultingPostDelete(Long id);


}
