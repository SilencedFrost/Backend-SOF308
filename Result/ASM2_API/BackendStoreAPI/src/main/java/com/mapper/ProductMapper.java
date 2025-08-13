package com.mapper;

import com.dto.InboundProductDTO;
import com.dto.OutboundProductDTO;
import com.dto.ProductDTO;
import com.entity.Category;
import com.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }
        return new OutboundProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getImageUrl(),
                product.isActive(),
                product.getProductDescription(),
                product.getCategory().getCategoryId(),
                product.getSpecifications(),
                product.getCreationDate(),
                product.getCarts().size(),
                product.getComments().size()
        );
    }

    public static Product toEntity(InboundProductDTO productDTO, Category category) {
        if (productDTO == null) {
            return null;
        }

        return new Product(
                productDTO.getProductName(),
                productDTO.getPrice(),
                productDTO.getStockQuantity(),
                productDTO.getImageUrl(),
                productDTO.isActive(),
                productDTO.getProductDescription(),
                category,
                productDTO.getSpecifications()
        );
    }

    public static List<ProductDTO> toDTOList(List<Product> entityList) {
        List<ProductDTO> dtoList = new ArrayList<>();
        for (Product product : entityList) {
            dtoList.add(ProductMapper.toDTO(product));
        }
        return dtoList;
    }
}
