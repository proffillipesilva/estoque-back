package com.fiec.estoqueback.features.product.repositories;

import com.fiec.estoqueback.features.product.models.Product;
import com.fiec.estoqueback.features.product.models.dto.ProductSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCustomRepository {
    List<Product> findProducts(ProductSearch productSearch);
}
