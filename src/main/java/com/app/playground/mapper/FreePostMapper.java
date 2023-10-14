package com.app.playground.mapper;


import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FreePostMapper {
//    게시물 작성
    public void insert(FreePostVO freePostVO);

//    게시물 전체 리스트(페이징처리)
    public List<FreePostVO> selectAll(@Param("pagination") Pagination pagination, @Param("Search") Search Search, @Param("keyword") String keyword);

//    게시물 list 총 개수
    public int selectTotal(Search Search);

//    게시물 목록
    public List<FreePostVO> selectSearch(Search search);

//    다음 게시물 id
    public Integer nextPost(Integer id);

//    이전 게시물 id
    public Integer prevPost(Integer id);



}
