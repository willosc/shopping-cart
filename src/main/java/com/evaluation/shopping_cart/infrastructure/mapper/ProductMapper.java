package com.evaluation.shopping_cart.infrastructure.mapper;

import com.evaluation.shopping_cart.model.dto.ProductDTO;
import com.evaluation.shopping_cart.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
}
