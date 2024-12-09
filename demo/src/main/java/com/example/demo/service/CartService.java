package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart findById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public void delete(Long id) {
        cartRepository.deleteById(id);
    }
}

