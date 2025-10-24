package com.fiec.estoqueback.features.product.services;

import com.fiec.estoqueback.features.product.models.dto.ProductDetailDto;
import com.fiec.estoqueback.features.product.models.dto.ProductDto;
import com.fiec.estoqueback.features.product.models.dto.ProductSearch;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    List<ProductDto> findAllWithQueries(ProductSearch productSearch);
    ProductDetailDto findById(String id);
}
