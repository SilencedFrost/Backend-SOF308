package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InboundProductDTO implements ProductDTO{
    private String productName;
    private BigDecimal price;
    private Integer stockQuantity;
    private String ImageUrl;
    private boolean active;
    private String productDescription;
    private Integer categoryId;
    private String specifications;
}