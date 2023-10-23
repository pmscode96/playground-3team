package com.app.playground.controller;

import com.app.playground.domain.PostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SearchController {
    public final PostService postService;

    @GetMapping("result/freepostsearch")
    public PostSearchDTO getResult(Search search, Pagination pagination, Model model){
//        pagination.setTotal(postService.selectTotal(search));
//        pagination.progress();
//        model.addAttribute("pagination", pagination);
//        return postService.searchPost(search);
        return null;
    }
}
