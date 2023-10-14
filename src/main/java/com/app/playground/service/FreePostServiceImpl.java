package com.app.playground.service;

import com.app.playground.domain.FreePostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.repository.FreePostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FreePostServiceImpl implements FreePostService {
    private final FreePostDAO freePostDAO;
//    게시물 작성
    @Override
    public void create(FreePostVO freePostVO) {freePostDAO.save(freePostVO);}

//    게시물 전체 리스트
    @Override
    public List<FreePostVO> list(Pagination pagination, Search Search, String keyword) {
        return freePostDAO.list(pagination, Search, keyword);
    }

//    게시물 리스트 count
    @Override
    public int selectTotal(Search search) {
        return freePostDAO.selectTotal(search);
    }

//    게시물 검색
    @Override
    public FreePostSearchDTO searchPost(Search search) {
        FreePostSearchDTO freePostSearchDTO = new FreePostSearchDTO();
        freePostSearchDTO.setFreePosts(freePostDAO.selectSearch(search));
        freePostSearchDTO.setFreePostsTotalCount(freePostDAO.selectTotal(search));
        return freePostSearchDTO;
    }

//    다음 게시물 id
    @Override
    public Integer nextPost(Integer id) {
        return freePostDAO.nextPost(id);
    }

//    이전 게시물 id
    @Override
    public Integer prevPost(Integer id) {
        return freePostDAO.prevPost(id);
    }


}
