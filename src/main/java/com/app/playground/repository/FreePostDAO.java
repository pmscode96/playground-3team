package com.app.playground.repository;


import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.mapper.FreePostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FreePostDAO {
    private final FreePostMapper freePostMapper;

//    게시물 작성
    public void save(FreePostVO freePostVO){freePostMapper.insert(freePostVO);}

//    게시물 전체 리스트
    public List<FreePostVO> list(Pagination pagination, Search Search, String keyword){return freePostMapper.selectAll(pagination, Search, keyword);}

//    게시물 리스트 카운트
    public int selectTotal(Search search){ return freePostMapper.selectTotal(search);}

//    게시물 검색
    public List<FreePostVO> selectSearch(Search search){return freePostMapper.selectSearch(search);}

//    다음 게시물 id
    public Integer nextPost(Integer id){return freePostMapper.nextPost(id);};

//    이전 게시물 id
    public Integer prevPost(Integer id){return freePostMapper.prevPost(id);};

}
