package org.cybersoft.buoi36.controller;

import org.cybersoft.buoi36.entity.ProductEntity;
import org.cybersoft.buoi36.payload.request.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api", produces = "application/json")
public interface ProductController {
    @GetMapping("/products")
    ResponseEntity<List<ProductEntity>> getProducts();

    @GetMapping("/product/{id}")
    ResponseEntity<ProductEntity> getProduct(@PathVariable Long id);

    @PostMapping("/product")
    ResponseEntity<ProductEntity> createProduct(@RequestBody Product product);

    @PatchMapping("/product/{id}")
    ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody Product product);

    @DeleteMapping("/product/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable Long id);
}
