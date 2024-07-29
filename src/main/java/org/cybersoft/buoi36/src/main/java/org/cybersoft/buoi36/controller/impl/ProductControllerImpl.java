package org.cybersoft.buoi36.controller.impl;

import org.cybersoft.buoi36.controller.ProductController;
import org.cybersoft.buoi36.entity.ProductEntity;
import org.cybersoft.buoi36.payload.request.Product;
import org.cybersoft.buoi36.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<List<ProductEntity>> getProducts() {
        return ResponseEntity.ok(this.productService.getProducts());
    }

    @Override
    public ResponseEntity<ProductEntity> getProduct(Long id) {
        ProductEntity product = this.productService.getProduct(id);

        if (product == null) {
            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<ProductEntity> createProduct(Product product) {
        return ResponseEntity.ok(this.productService.createProduct(product));
    }

    @Override
    public ResponseEntity<ProductEntity> updateProduct(Long id, Product product) {
        return ResponseEntity.ok(this.productService.updateProduct(id, product));
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long id) {
        ProductEntity product = this.productService.deleteProduct(id);

        if (product == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok("Delete Success");
    }
}
