package com.app.playground.repository;


import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.*;
import com.app.playground.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostDAO {
    private final PostMapper postMapper;

//    게시물 작성(공통)
    public void save(PostDTO postDTO){
        postMapper.insert(postDTO);}

//    자유게시판
    public void saveFreePost(PostDTO postDTO){
        postMapper.insertFreePost(postDTO);
    }

//    고민게시판
    public void saveConsultingPost(PostDTO postDTO){
        postMapper.insertConsultingPost(postDTO);
    };


//    게시물 상세보기 자유게시판
    public Optional<FreePostDTO> selectByFreePostId(Long id){return postMapper.selectFreePost(id);}

//    게시물 상세보기 고민게시판
    public Optional<ConsultingPostDTO> selectByConsultingPostId(Long id){return postMapper.selectConsultingPost(id);}

//    자유게시판 게시물 전체 리스트(페이징처리)
    public List<FreePostDTO> selectFreePostList(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword, @Param("userId") Long userId){
       return postMapper.selectFreePostList(pagination, search, keyword, userId);
    };

//    자유게시판 게시물 전체 리스트(페이징처리)
    public List<ConsultingPostDTO> selectConsultingPostList(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword, @Param("userId") Long userId){
        return postMapper.selectConsultingPostList(pagination, search, keyword, userId);
    };

//    게시물 list 총 개수
    public int selectTotalFreePost(Search search){return postMapper.selectTotalFreePost(search);};

//    게시물 list 총 개수
    public int selectTotalConsultingPost(Search search){return postMapper.selectTotalConsultingPost(search);};

//    게시물 목록
    public List<FreePostDTO> selectSearchFreePost(Search search){return postMapper.selectSearchFreePost(search);};

//    게시물 목록
    public List<ConsultingPostDTO> selectSearchConsultingPost(Search search){return postMapper.selectSearchConsultingPost(search);};

//    게시물 수정
    public void postUpdate(PostVO postVO){
        postMapper.postUpdate(postVO);};

//    댓글 달기
    public void replyInsert(ReplyDTO replyDTO){ postMapper.replyInsert(replyDTO);};

//    자유게시판 댓글 작성
    public void freePostReplyInsert(ReplyDTO replyDTO){postMapper.freePostReplyInsert(replyDTO);};

//    고민게시판 댓글 작성
    public void consultingPostReplyInsert(ReplyDTO replyDTO){
        postMapper.consultingPostReplyInsert(replyDTO);
    };

//    자유게시판 댓글 리스트
    public List<ReplyDTO> freePostReplyList(Long postId){return postMapper.freePostReplyList(postId);};

//    고민게시판 댓글 리스트
    public List<ReplyDTO> consultingPostReplyList(Long postId){return postMapper.consultingPostReplyList(postId);};

//    댓글 수정
    public void replyUpdate(ReplyVO replyVO){
        postMapper.replyUpdate(replyVO);};

//    댓글 삭제
    public void replyDelete(Long id){postMapper.replyDelete(id);};

//    자유게시판 댓글 삭제
    public void freePostReplyDelete(Long id){postMapper.freePostReplyDelete(id);};

//   고민게시판 댓글 삭제
    public void consultingPostReplyDelete(Long id){postMapper.consultingPostReplyDelete(id);};

//    자유게시판 댓글 좋아요
    public void freePostReplyLike(FreePostReplyLikeVO freePostReplyLikeVO){postMapper.freePostReplyLike(freePostReplyLikeVO);};

//    자유게시판 댓글 좋아요 취소
    public void freePostReplyLikeDelete(Long id){postMapper.freePostReplyLikeDelete(id);};

//    고민게시판 댓글 좋아요
    public void consultingPostReplyLike(ConsultingPostReplyLikeVO consultingPostReplyLikeVO){postMapper.consultingPostReplyLike(consultingPostReplyLikeVO);};

//    고민게시판 댓글 좋아요 취소
    public void consultingPostReplyLikeDelete(Long id){postMapper.consultingPostReplyLikeDelete(id);};

//    게시글 삭제
    public void postDelete(Long id){postMapper.postDelete(id);};

//    자유게시판 게시글 삭제
    public void freePostDelete(Long id){postMapper.freePostDelete(id);};

//    고민게시판 게시글 삭제
    public void consultingPostDelete(Long id){postMapper.consultingPostDelete(id);};

//    자유게시판 게시글 좋아요
    public void freePostLike(FreePostLikeVO freePostLikeVO){postMapper.freePostLike(freePostLikeVO);};

//    자유게시판 게시글 좋아요 취소
    public void freePostLikeDelete(Long id){postMapper.freePostLikeDelete(id);};

//    고민게시판 게시글 좋아요
    public void consultingPostLike(ConsultingPostLikeVO consultingPostLikeVO){postMapper.consultingPostLike(consultingPostLikeVO);};

//    고민게시판 게시글 좋아요 취소
    public void consultingPostLikeDelete(Long id){postMapper.consultingPostLikeDelete(id);};

//    자유게시판 해당 게시물 댓글 전체 삭제
    public void freePostReplyDeleteAll(Long postId){postMapper.freePostReplyDeleteAll(postId);};

//    자유게시판 해당 게시물 댓글 좋아요 전체 삭제
    public void freePostReplyLikeDeleteAll(Long postId){postMapper.freePostReplyLikeDeleteAll(postId);};

//    고민게시판 해당 게시물 댓글 전체 삭제
    public void consultingPostReplyDeleteAll(Long postId){postMapper.consultingPostReplyDeleteAll(postId);};

//    고민게시판 해당 게시물 댓글 좋아요 전체 삭제
    public void consultingPostReplyLikeDeleteAll(Long postId){postMapper.consultingPostReplyLikeDeleteAll(postId);};


//    자유게시판 댓글 좋아요 전체 삭제
    public void freePostReplyLikeDeleteAllByReplyId(Long replyId){postMapper.freePostReplyLikeDeleteAllByReplyId(replyId);};

//    고민게시판 댓글 좋아요 전체 삭제
    public void consultingPostReplyLikeDeleteAllByReplyId(Long replyId){postMapper.consultingPostReplyLikeDeleteAllByReplyId(replyId);};
}
