package com.app.playground.service;

import com.app.playground.domain.VO.NoticeVO;
import com.app.playground.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDAO noticeDAO;

    @Override
    public void create(NoticeVO noticeVO) {
        noticeDAO.save(noticeVO);
    }
}
