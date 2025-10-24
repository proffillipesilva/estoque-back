package com.fiec.estoqueback.features.product.services.impl;

import com.fiec.estoqueback.features.product.models.Product;
import com.fiec.estoqueback.features.product.models.dto.ProductDetailDto;
import com.fiec.estoqueback.features.product.models.dto.ProductDto;
import com.fiec.estoqueback.features.product.models.dto.ProductSearch;
import com.fiec.estoqueback.features.product.repositories.ProductRepository;
import com.fiec.estoqueback.features.product.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        return List.of();
    }

    @Override
    public List<ProductDto> findAllWithQueries(ProductSearch productSearch) {
        List<Product> myProducts = productRepository.findProducts(productSearch);
        if(CollectionUtils.isEmpty(myProducts)) {
            return List.of();
        } else {
            return myProducts.stream().map(
                    product -> ProductDto.builder()
                            .preco(product.getPreco())
                            .nome(product.getNome())
                            .imagem(product.getImagem())
                            .id(String.valueOf(product.getId()))
                            .build()
            ).toList();
        }
    }

    @Override
    public ProductDetailDto findById(String id) {
        return null;
    }
}
