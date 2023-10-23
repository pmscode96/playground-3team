package com.app.playground.mapper;


import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface InquirePostMapper {
//    게시물 작성
    public void insertInquirePost(InquirePostVO inquirePostVO);

//    게시물 상세보기
    public Optional<InquirePostVO> selectInquirePost(Long id);

//    게시물 전체 리스트(페이징처리)
    public List<InquirePostVO> selectAllPost(@Param("pagination") Pagination pagination, @Param("Search") Search Search, @Param("keyword") String keyword);

//    게시물 list 총 개수
    public int selectTotalInquirePost(Search Search);

//    게시물 검색 목록
    public List<InquirePostVO> selectSearchInquirePost(Search search);

//    게시물 수정
    public void postUpdate(InquirePostVO inquirePostVO);

//    게시물 삭제
    public void delete(Long id);

}
