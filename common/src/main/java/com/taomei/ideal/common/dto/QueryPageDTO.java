package com.taomei.ideal.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPageDTO implements Serializable {
    private Integer pageNumber = 1;
    private Integer pageSize = 10;

}
