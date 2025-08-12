package com.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryFields implements Automatable {
    CATEGORY_ID("categoryId"),
    CATEGORY_NAME("categoryName");

    private final String propertyKey;
}
