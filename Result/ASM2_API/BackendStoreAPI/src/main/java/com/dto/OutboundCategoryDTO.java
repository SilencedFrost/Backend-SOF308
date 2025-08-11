package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutboundCategoryDTO {
    private Integer categoryId;
    private String categoryName;
    private Integer productCount;
}
