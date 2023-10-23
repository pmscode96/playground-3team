package com.app.playground.service;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.PostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
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
    public List<FreePostDTO> freePostList(Pagination pagination, Search search, String keyword) {
        return postDAO.selectFreePostList(pagination, search, keyword);
    }

//    고민게시판 리스트
    @Override
    public List<ConsultingPostDTO> consultingPostList(Pagination pagination, Search search, String keyword) {
        return postDAO.selectConsultingPostList(pagination, search, keyword);
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

//    게시물 수정
    @Override
    public void postUpdate(PostVO postVO) {
        postDAO.postUpdate(postVO);
    }

    @Override
    public void replyInsert(ReplyVO replyVO) {
        postDAO.replyInsert(replyVO);
    }

    @Override
    public void freePostReplyInsert(FreePostReplyVO freePostReplyVO) {
        postDAO.freePostReplyInsert(freePostReplyVO);
    }

    @Override
    public void consultingPostReplyInsert(ConsultingPostReplyVO consultingPostReplyVO) {
        postDAO.consultingPostReplyInsert(consultingPostReplyVO);
    }

//    게시물 댓글 수정
    @Override
    public void replyUpdate(ReplyVO replyVO) {
        postDAO.replyUpdate(replyVO);
    }

    @Override
    public void replyDelete(Long id) {
        postDAO.replyDelete(id);
    }

    @Override
    public void freePostReplyDelete(Long id) {
        postDAO.freePostReplyDelete(id);
    }

    @Override
    public void consultingPostReplyDelete(Long id) {
        postDAO.consultingPostReplyDelete(id);
    }

    @Override
    public void freePostDelete(Long id) {

    }

    @Override
    public void consultingPostDelete(Long id) {

    }


}
