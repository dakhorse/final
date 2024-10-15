package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        // Phương thức tìm tất cả sản phẩm
        public List<Product> findAll() {
            return productRepository.findAll();
        }

        // Phương thức tìm sản phẩm theo ID
        public Product findById(Long id) {
            return productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
        }

        // Phương thức lưu sản phẩm (cho việc tạo mới hoặc cập nhật sản phẩm)
        public Product save(Product product) {
            return productRepository.save(product);
        }

        // Phương thức xóa sản phẩm theo ID
        public void delete(Long id) {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
            } else {
                throw new RuntimeException("Product not found");
            }
        }
    }
