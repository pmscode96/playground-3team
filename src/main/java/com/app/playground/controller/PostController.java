package com.app.playground.controller;

import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.Pagination;
import com.app.playground.domain.Search;
import com.app.playground.domain.VO.FreePostVO;
import com.app.playground.domain.VO.PostVO;
import com.app.playground.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {
    public final PostService postService;

    @GetMapping("/charge")
    public void goToPostCharge(){;}

    @GetMapping("/expected-problem")
    public void goToExpectedProblem(){;}

    @GetMapping("/expected-problem-detail")
    public void goToExpectedProblemDetail(){;}

    @GetMapping("/free-post")
    public void goToFreePost(Pagination pagination, Search search, Model model, HttpServletRequest request){
        String keyword = "";
        if((String)request.getParameter("keyword")!=null) {
            keyword = (String) request.getParameter("keyword");
        }
        pagination.setTotal(postService.selectTotalFreePost(search));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        search.setKeyword(keyword);

        model.addAttribute("posts", postService.freePostList(pagination, search, keyword));
        model.addAttribute("keyword",keyword);
    }

    @PostMapping("/free-post")
    public RedirectView goToJoinFreePostDetail(Long id, HttpSession session) {
        Optional<FreePostDTO> foundPost = postService.freePostDetail(id);
        if(foundPost.isPresent()){
            session.setAttribute("event", foundPost.get());
            return new RedirectView("/event/event-detail");
        }
        return new RedirectView("/event/event");
    }

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
