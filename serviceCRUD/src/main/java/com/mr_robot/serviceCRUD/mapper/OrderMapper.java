package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.OrderDTO;
import com.mr_robot.serviceCRUD.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, ProductMapper.class})
public interface OrderMapper {
    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO orderDTO);
}
