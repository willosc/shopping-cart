package com.evaluation.shopping_cart.infrastructure.mapper;

import com.evaluation.shopping_cart.model.dto.CustomerDTO;
import com.evaluation.shopping_cart.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    @Mapping(target = "id", ignore = true)
    Customer fromDTO(CustomerDTO dto);
}
