package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController{
    @Autowired
    private CartService cartService;
    private CartRepository repo;
    @GetMapping
    @ResponseBody
    public List<Cart> getAllCarts(){
        return cartService.findAll();
    @GetMapping({"", "/"})
    public String ShowProductList(Model model){
            List<Cart> products = repo.findAll();//Sort.by(Sort.Direction.DESC, "id")
            model.addAttribute("products", products);
            return "products/cart";
    }
    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cart> getCartById(@PathVariable Long id){
        Cart cart = cartService.findById(id);
        return ResponseEntity.ok(cart);
    }
    @PostMapping
    @ResponseBody
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        Cart newCart = cartService.save(cart);
        return ResponseEntity.status(201).body(newCart);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cartDetails){
        Cart cart = cartService.findById(id);
        cart.setProductList(cartDetails.getProductList());
        cart.setTotalAmount(cartDetails.getTotalAmount());
        cartService.save(cart);
        return ResponseEntity.ok(cart);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteCart(@PathVariable Long id){
        cartService.delete(id);
        return ResponseEntity.noContent().build();
    }
}