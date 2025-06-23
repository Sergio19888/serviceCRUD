package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.OrderCreateDTO;
import com.mr_robot.serviceCRUD.DTO.OrderDTO;
import com.mr_robot.serviceCRUD.mapper.OrderMapper;
import com.mr_robot.serviceCRUD.model.Client;
import com.mr_robot.serviceCRUD.model.Order;
import com.mr_robot.serviceCRUD.model.OrderStatus;
import com.mr_robot.serviceCRUD.model.Product;
import com.mr_robot.serviceCRUD.repository.ClientRepository;
import com.mr_robot.serviceCRUD.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ClientRepository clientRepository;

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
        order.setProductes(products);
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
        existingOrder.setClient(orderDTO.getClient());
        existingOrder.setProductes(orderDTO.getProductes());
        Order updateOrder = orderRepository.save(existingOrder);

        return orderMapper.toDTO(updateOrder);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public List<OrderDTO> getAllOrder() {
        return orderRepository.findAll().stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

}
