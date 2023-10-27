package com.app.playground.controller;


import com.app.playground.domain.*;
import com.app.playground.service.InquirePostService;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostSearchController {
    public final InquirePostService inquirePostService;
    private final PostService postService;


    @GetMapping("results/inquire-search")
    public InquirePostSearchDTO getResult(Search search, Pagination pagination, Model model){
        pagination.setTotal(inquirePostService.listTotal(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        return inquirePostService.searchPost(search);
    }

    @GetMapping("results/free-search")
    public FreePostSearchDTO getFreePostResult(Search search, Pagination pagination, Model model) {
        pagination.setTotal(postService.selectTotalFreePost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        return postService.searchFreePost(search);
    }

    @GetMapping("results/consulting-search")
    public ConsultingPostSearchDTO getConsultingPostResult(Search search, Pagination pagination, Model model){
        pagination.setTotal(postService.selectTotalConsultingPost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        return postService.searchConsultingPost(search);
    }


}
