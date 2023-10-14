package com.app.playground.domain;

import com.app.playground.domain.VO.FreePostVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class FreePostSearchDTO {
    private List<FreePostVO> freePosts;
    private int freePostsTotalCount;
}
