package com.app.playground.domain;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class FreePostSearchDTO {
    private List<FreePostDTO> freePosts;
    private int postsTotalCount;
}
