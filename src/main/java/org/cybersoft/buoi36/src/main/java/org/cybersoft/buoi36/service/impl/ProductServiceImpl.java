package org.cybersoft.buoi36.service.impl;

import org.cybersoft.buoi36.entity.ProductEntity;
import org.cybersoft.buoi36.payload.request.Product;
import org.cybersoft.buoi36.repository.ProductRepository;
import org.cybersoft.buoi36.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductEntity getProduct(Long id) {
        Optional<ProductEntity> productEntity = this.productRepository.findById(id);
        return productEntity.orElse(null);
    }

    @Override
    public ProductEntity createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity(
                product.name(),
                product.description()
        );

        return this.productRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(Long id, Product product) {
        ProductEntity productEntity = this.getProduct(id);

        if (productEntity == null) {
            return null;
        }

        productEntity.setName(product.name());
        productEntity.setDescription(product.description());

        return this.productRepository.save(productEntity);
    }

    @Override
    public ProductEntity deleteProduct(Long id) {
        ProductEntity productEntity = this.getProduct(id);

        if (productEntity == null) {
            return null;
        }

        this.productRepository.delete(productEntity);

        return productEntity;
    }
}
