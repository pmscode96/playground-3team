package com.app.playground.controller;

import com.app.playground.domain.FreePostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.service.FreePostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SearchController {
    public final FreePostService freePostService;

    @GetMapping("result/freepostsearch")
    public FreePostSearchDTO getResult(Search search, Pagination pagination, Model model){
        pagination.setTotal(freePostService.selectTotal(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        return freePostService.searchPost(search);
    }
}
