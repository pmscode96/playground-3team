package com.app.playground.service;

import com.app.playground.domain.DTO.InquirePostSearchDTO;
import com.app.playground.domain.DTO.Pagination;
import com.app.playground.domain.DTO.Search;
import com.app.playground.domain.VO.InquirePostVO;
import com.app.playground.repository.InquirePostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InquirePostServiceImpl implements InquirePostService {
    public final InquirePostDAO inquirePostDAO;

//    게시물 작성
    @Override
    public void create(InquirePostVO inquirePostVO) {
        inquirePostDAO.create(inquirePostVO);
    }

//    게시물 상세보기
    @Override
    public Optional<InquirePostVO> postDetail(Long id) {
        return inquirePostDAO.select(id);
    }

//    게시물 전체 리스트
    @Override
    public List<InquirePostVO> postList(Pagination pagination, Search search, String keyword, Long userId) {
        return inquirePostDAO.List(pagination, search, keyword, userId);
    }

    @Override
    public int listTotal(Search search) {
        return 0;
    }

    @Override
    public InquirePostSearchDTO searchPost(Search search) {
        InquirePostSearchDTO inquirePostSearchDTO = new InquirePostSearchDTO();
        inquirePostSearchDTO.setInquirePosts(inquirePostDAO.searchList(search));
        inquirePostSearchDTO.setPostsTotalCount(inquirePostDAO.listTotal(search));
        return inquirePostSearchDTO;
    }

    //    게시물 업데이트
    @Override
    public void update(InquirePostVO inquirePostVO) {
        inquirePostDAO.update(inquirePostVO);
    }

//    게시물 삭제
    @Override
    public void delete(Long id) {
        inquirePostDAO.delete(id);
    }
}
