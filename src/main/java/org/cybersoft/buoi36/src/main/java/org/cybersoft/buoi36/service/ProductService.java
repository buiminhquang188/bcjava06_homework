package org.cybersoft.buoi36.service;

import org.cybersoft.buoi36.entity.ProductEntity;
import org.cybersoft.buoi36.payload.request.Product;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getProducts();

    ProductEntity getProduct(Long id);

    ProductEntity createProduct(Product product);

    ProductEntity updateProduct(Long id, Product product);

    ProductEntity deleteProduct(Long id);
}
