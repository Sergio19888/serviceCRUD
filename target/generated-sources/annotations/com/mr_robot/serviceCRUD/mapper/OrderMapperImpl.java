package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.OrderDTO;
import com.mr_robot.serviceCRUD.DTO.ProductDTO;
import com.mr_robot.serviceCRUD.model.Order;
import com.mr_robot.serviceCRUD.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-25T18:28:39+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ProductMapper productMapper;

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
        orderDTO.setProducts( productListToProductDTOList( order.getProducts() ) );

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
        order.setProducts( productDTOListToProductList( orderDTO.getProducts() ) );

        return order;
    }

    protected List<ProductDTO> productListToProductDTOList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDTO> list1 = new ArrayList<ProductDTO>( list.size() );
        for ( Product product : list ) {
            list1.add( productMapper.toDTO( product ) );
        }

        return list1;
    }

    protected List<Product> productDTOListToProductList(List<ProductDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ProductDTO productDTO : list ) {
            list1.add( productMapper.toEntity( productDTO ) );
        }

        return list1;
    }
}
