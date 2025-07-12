package com.mr_robot.serviceCRUD.controller;

import com.mr_robot.serviceCRUD.DTO.OrderCreateDTO;
import com.mr_robot.serviceCRUD.DTO.OrderDTO;
import com.mr_robot.serviceCRUD.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

       @PostMapping

    public ResponseEntity<OrderDTO> create(@Valid @RequestBody OrderCreateDTO request){
        OrderDTO createOrder = orderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity <OrderDTO> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updateOrder = orderService.update(id, orderDTO);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Page<OrderDTO>> getAllOrders (Pageable pageable) {
        Page<OrderDTO> orders = orderService.getAllOrders(pageable);
        return ResponseEntity.ok(orders);
    }
}
