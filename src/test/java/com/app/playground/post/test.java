package com.app.playground.post;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostReplyLikeVO;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.NoticeVO;
import com.app.playground.domain.VO.PostVO;
import com.app.playground.mapper.MainMapper;
import com.app.playground.mapper.PostMapper;
import com.app.playground.mapper.NoticeMapper;
import com.app.playground.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Random;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private PostService postService;

    @Autowired
    private MainMapper mainMapper;

//    @Test
//    public void postSelectTest(){
//        postMapper.select(41L).stream().map(FreePostVO::toString).forEach(log::info);
//    }

    @Test
    public void insertTest(){
        Random random = new Random();
        PostDTO postDTO = null;
        int idx = 0;
        for (int i=0; i<60; i++){
            postDTO = new PostDTO();
            idx = random.nextInt(60) + 1;
            postDTO.setUserId(1L);
            postDTO.setCategory("consulting");
            postDTO.setPostTitle("테스트 제목" + idx);
            postDTO.setPostContent("테스트 내용" + idx);
            postService.createConsultingPost(postDTO);
        }
    }

    @Test
    public void insertReplyTest(){
        Random random = new Random();
        ReplyDTO replyDTO = null;
        int idx = 0;
        for (int i=0; i<10; i++){
            replyDTO = new ReplyDTO();
            idx = random.nextInt(10) + 1;
            replyDTO.setUserId(1L);
            replyDTO.setReplyContent("테스트 내용" + idx);
            replyDTO.setPostId(1L);
            postService.freePostReplyInsert(replyDTO);
        }
    }

    @Test
    public void insertPostTest(){
        PostDTO postDTO = new PostDTO();
        postDTO.setPostTitle("테스트 제목 1");
        postDTO.setPostContent("테스트 내용 1");
        postDTO.setUserId(1L);

        postService.createConsultingPost(postDTO);
    }

    @Test
    public void postSelectTest(){
//        postMapper.selectConsultingPost(1L).stream().map(ConsultingPostDTO::toString).forEach(log::info);
    }

    @Test
    public void postSelectListTest(){
        Pagination pagination = new Pagination();
        Long userId = null;
        Search search = new Search();
        String keyword = "12";
        pagination.setTotal(10);
        pagination.setPage(1);
        pagination.setEndRow(10);
        pagination.setStartRow(1);
        postMapper.selectFreePostList(pagination, search, keyword, userId).stream().map(FreePostDTO::toString).forEach(log::info);
//        postMapper.selectConsultingPost(23L).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void likeSelectTest(){
        FreePostReplyLikeVO freePostReplyLikeVO = new FreePostReplyLikeVO();
        freePostReplyLikeVO.setUserId(2L);
        freePostReplyLikeVO.setReplyId(204L);

        log.info(String.valueOf(postMapper.freePostReplyLikeSelect(freePostReplyLikeVO)));
    }

    @Test
    public void replyListSelectTest(){

        log.info("1234asdf");
//        postService.freePostReplyList(402L).stream().map(ReplyDTO::toString).forEach(log::info);
        log.info("1234asdf");
    }

    @Test
    public void mainListTest(){
        mainMapper.randomList().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void NoticeInsertTest(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("테스트1");
        noticeVO.setNoticeContent("테스트내용1");
//        noticeVO.setNoticeCreateDate("2023-10-19");
        noticeVO.setAdministratorId(4L);

        noticeMapper.insert(noticeVO);
    }
}
