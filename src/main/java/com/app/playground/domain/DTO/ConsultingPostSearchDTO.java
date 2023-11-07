package com.app.playground.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ConsultingPostSearchDTO {
    private List<ConsultingPostDTO> consultingPosts;
    private Pagination pagination;
    private int postsTotalCount;
}
