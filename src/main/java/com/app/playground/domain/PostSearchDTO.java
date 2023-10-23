package com.app.playground.domain;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.InquirePostDTO;
import com.app.playground.domain.VO.FreePostVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PostSearchDTO {
    private List<FreePostDTO> freePosts;
    private List<ConsultingPostDTO> consultingPosts;
    private int postsTotalCount;
}
