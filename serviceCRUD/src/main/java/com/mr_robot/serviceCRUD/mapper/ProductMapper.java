package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.ProductDTO;
import com.mr_robot.serviceCRUD.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
