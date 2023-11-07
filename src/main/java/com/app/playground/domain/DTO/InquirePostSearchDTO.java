package com.app.playground.domain.DTO;

import com.app.playground.domain.DTO.ConsultingPostDTO;
import com.app.playground.domain.DTO.FreePostDTO;
import com.app.playground.domain.DTO.InquirePostDTO;
import com.app.playground.domain.VO.InquirePostVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class InquirePostSearchDTO {
    private List<InquirePostVO> inquirePosts;
    private int postsTotalCount;
}
