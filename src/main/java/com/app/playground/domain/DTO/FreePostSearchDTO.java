package com.app.playground.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class FreePostSearchDTO {
    private List<FreePostDTO> freePosts;
    private Pagination pagination;
    private int postsTotalCount;
}
