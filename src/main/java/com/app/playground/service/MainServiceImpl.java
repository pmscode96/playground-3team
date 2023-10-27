package com.app.playground.service;

import com.app.playground.domain.DTO.PostDTO;
import com.app.playground.domain.DTO.ReplyDTO;
import com.app.playground.repository.MainDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final MainDAO mainDAO;

//    베스트 댓글
    @Override
    public Optional<ReplyDTO> selectBestReply() {
        return mainDAO.selectBestReply();
    }

//    게시글 총 갯수
    @Override
    public int selectPostCount() {
        return mainDAO.selectPostCount();
    }

    @Override
    public List<PostDTO> randomList() {
        return mainDAO.randomList();
    }
}
