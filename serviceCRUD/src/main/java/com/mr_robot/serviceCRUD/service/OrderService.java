package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.OrderCreateDTO;
import com.mr_robot.serviceCRUD.DTO.OrderDTO;
import com.mr_robot.serviceCRUD.mapper.ClientMapper;
import com.mr_robot.serviceCRUD.mapper.OrderMapper;
import com.mr_robot.serviceCRUD.mapper.ProductMapper;
import com.mr_robot.serviceCRUD.model.Client;
import com.mr_robot.serviceCRUD.model.Order;
import com.mr_robot.serviceCRUD.model.OrderStatus;
import com.mr_robot.serviceCRUD.model.Product;
import com.mr_robot.serviceCRUD.repository.ClientRepository;
import com.mr_robot.serviceCRUD.repository.OrderRepository;
import com.mr_robot.serviceCRUD.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientMapper clientMapper;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public OrderDTO create(OrderCreateDTO request) {

        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Такого клиента нет"));

        List<Product> products = productRepository.findAllById(request.getProductIds());
        if (products.size() != request.getProductIds().size()) {
            throw new RuntimeException("Некоторые товары не найдены");
        }

        // Создать заказ
        Order order = new Order();
        order.setClient(client);
        order.setProducts(products);
        order.setDateTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.NEW); // или по умолчанию

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDTO(savedOrder);

    }


    public OrderDTO update(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Такого заказа нет"));
        existingOrder.setDateTime(orderDTO.getDateTime());
        existingOrder.setOrderStatus(orderDTO.getOrderStatus());
        existingOrder.setClient(clientMapper.toEntity(orderDTO.getClient()));
        existingOrder.setProducts(orderDTO.getProducts().stream().map(productMapper :: toEntity).toList());
        Order updateOrder = orderRepository.save(existingOrder);

        return orderMapper.toDTO(updateOrder);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Page<OrderDTO> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(orderMapper::toDTO);
    }

}
