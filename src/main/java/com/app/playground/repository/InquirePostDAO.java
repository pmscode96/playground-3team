package com.app.playground.repository;


import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.*;
import com.app.playground.mapper.InquirePostMapper;
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
public class InquirePostDAO {
    private final InquirePostMapper inquirePostMapper;

    //    게시물 작성
    public void create(InquirePostVO inquirePostVO){inquirePostMapper.insertInquirePost(inquirePostVO);};

    //    게시물 상세보기
    public Optional<InquirePostVO> select(Long id){return inquirePostMapper.selectInquirePost(id);};

    //    게시물 전체 리스트(페이징처리)
    public List<InquirePostVO> List(@Param("pagination") Pagination pagination, @Param("Search") Search search, @Param("keyword") String keyword){
        return inquirePostMapper.selectAllPost(pagination, search, keyword);
    };

    //    게시물 list 총 개수
    public int listTotal(Search search){
       return inquirePostMapper.selectTotalInquirePost(search);
    };

    //    게시물 검색 목록
    public List<InquirePostVO> searchList(Search search){
        return inquirePostMapper.selectSearchInquirePost(search);
    };

    //    게시물 수정
    public void update(InquirePostVO inquirePostVO){
        inquirePostMapper.postUpdate(inquirePostVO);
    };

    //    게시물 삭제
    public void delete(Long id){
        inquirePostMapper.delete(id);
    };
}
