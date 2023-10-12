package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {

    @GetMapping("/charge")
    public void goToPostCharge(){;}

    @GetMapping("/expected-problem")
    public void goToExpectedProblem(){;}

    @GetMapping("/expected-problem-detail")
    public void goToExpectedProblemDetail(){;}

    @GetMapping("/free-post")
    public void goToFreePost(){;}

    @GetMapping("/most-recommended-posts")
    public void goToMostRecommendedPosts(){;}

    @GetMapping("/most-recommended-posts-detail")
    public void goToMostRecommendedPostsDetail(){;}

    @GetMapping("/post")
    public void goToPost(){;}

    @GetMapping("/post-detail")
    public void goToPostDetail(){;}

    @GetMapping("/school-post")
    public void goToSchoolPost(){;}

    @GetMapping("/write")
    public void goToWrite(){;}
}
