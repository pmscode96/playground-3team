package com.app.playground.controller;


import com.app.playground.domain.InquirePostSearchDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.service.InquirePostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostSearchController {
    public final InquirePostService inquirePostService;


    @GetMapping("results/inquire-search")
    public InquirePostSearchDTO getResult(Search search, Pagination pagination, Model model){
        pagination.setTotal(inquirePostService.listTotal(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        return inquirePostService.searchPost(search);
    }


}
