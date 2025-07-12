package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.OrderDTO;
import com.mr_robot.serviceCRUD.model.Order;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-12T11:34:57+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public OrderDTO toDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setDateTime( order.getDateTime() );
        orderDTO.setOrderStatus( order.getOrderStatus() );
        orderDTO.setClient( clientMapper.toDTO( order.getClient() ) );

        return orderDTO;
    }

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setDateTime( orderDTO.getDateTime() );
        order.setOrderStatus( orderDTO.getOrderStatus() );
        order.setClient( clientMapper.toEntity( orderDTO.getClient() ) );

        return order;
    }
}
