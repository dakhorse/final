package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // API để lấy danh sách tất cả đơn hàng
    @GetMapping
    @ResponseBody
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    // API để lấy thông tin đơn hàng theo ID
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    // API để tạo mới đơn hàng
    @PostMapping
    @ResponseBody
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderService.save(order);
        return ResponseEntity.status(201).body(newOrder);
    }

    // API để cập nhật đơn hàng theo ID
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order order = orderService.findById(id);

        // Cập nhật các thuộc tính của đơn hàng
        order.setCustomerId(orderDetails.getCustomerId());
        order.setProductList(orderDetails.getProductList());
        order.setTotalPrice(orderDetails.getTotalPrice());
        order.setStatus(orderDetails.getStatus());

        orderService.save(order);
        return ResponseEntity.ok(order);
    }

    // API để xóa đơn hàng theo ID
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
