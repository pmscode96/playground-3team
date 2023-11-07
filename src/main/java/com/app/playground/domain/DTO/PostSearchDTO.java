package com.app.playground.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PostSearchDTO {
    private List<FreePostDTO> freePosts;
    private List<ConsultingPostDTO> consultingPosts;
    private Pagination pagination;
    private int postsTotalCount;
}
