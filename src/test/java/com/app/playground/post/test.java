package com.app.playground.post;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.NoticeVO;
import com.app.playground.domain.VO.PostVO;
import com.app.playground.mapper.PostMapper;
import com.app.playground.mapper.NoticeMapper;
import com.app.playground.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private PostService postService;

//    @Test
//    public void postSelectTest(){
//        postMapper.select(41L).stream().map(FreePostVO::toString).forEach(log::info);
//    }

    @Test
    public void insertTest(){
        PostDTO postDTO = new PostDTO();
        postDTO.setPostTitle("테스트 제목 1");
        postDTO.setPostContent("테스트 내용 1");
        postDTO.setUserId(1L);

        postService.createFreePost(postDTO);
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
        postMapper.selectConsultingPost(23L).stream().map(ConsultingPostDTO::toString).forEach(log::info);
    }

    @Test
    public void postSelectListTest(){
        Pagination pagination = new Pagination();
        Search search = new Search();
        String keyword = "";
        pagination.setTotal(10);
        pagination.setPage(1);
        pagination.setEndRow(10);
        pagination.setStartRow(1);
        postMapper.selectConsultingPostList(pagination, search, keyword).stream().map(ConsultingPostDTO::toString).forEach(log::info);
//        postMapper.selectConsultingPost(23L).stream().map(PostDTO::toString).forEach(log::info);
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
