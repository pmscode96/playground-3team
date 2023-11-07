package com.app.playground.service;


import com.app.playground.domain.DTO.InquirePostSearchDTO;
import com.app.playground.domain.DTO.Pagination;
import com.app.playground.domain.DTO.Search;
import com.app.playground.domain.VO.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface InquirePostService {
    //    게시물 작성
    public void create(InquirePostVO inquirePostVO);

    //    게시물 상세보기
    public Optional<InquirePostVO> postDetail(Long id);

    //    게시물 전체 리스트(페이징처리)
    public List<InquirePostVO> postList(@Param("pagination") Pagination pagination, @Param("Search") Search Search, @Param("keyword") String keyword, @Param("userId") Long userId);

    //    게시물 list 총 개수
    public int listTotal(Search Search);

    //    게시물 검색
    public InquirePostSearchDTO searchPost(Search search);

    //    게시물 수정
    public void update(InquirePostVO inquirePostVO);

    //    게시물 삭제
    public void delete(Long id);

}
