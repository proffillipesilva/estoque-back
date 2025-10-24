package com.fiec.estoqueback.features.product.controllers;

import com.fiec.estoqueback.features.product.models.dto.ProductDetailDto;
import com.fiec.estoqueback.features.product.models.dto.ProductDto;
import com.fiec.estoqueback.features.product.models.dto.ProductSearch;
import com.fiec.estoqueback.features.product.models.enums.TipoMedida;
import com.fiec.estoqueback.features.product.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/produtos")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() throws InterruptedException {
        //Thread.sleep(5000);
        List<ProductDto> productDtos = new ArrayList<>();
        ProductDto productDto = ProductDto.builder()
                .id("1")
                .nome("Notebook Ultra")
                .imagem("https://m.media-amazon.com/images/I/51qH44JtGtL.jpg")
                .preco(5499.99)
                .build();
        productDtos.add(productDto);
        return productDtos;
    }

    @GetMapping("/{id}")
    public ProductDetailDto getProductById(@PathVariable("id") String id){
        ProductDetailDto productDetailDto = ProductDetailDto.builder()
                .id(id)
                .nome("Notebook Ultra")
                .imagem("https://m.media-amazon.com/images/I/51qH44JtGtL.jpg")
                .preco(5499.99)
                .guestName("Loja do Francisco")
                .quantidade(55.0)
                .tipoMedida(TipoMedida.UN)
                .build();
        return productDetailDto;
    }

    @GetMapping("/filters/all")
    public List<ProductDto> getProductById(ProductSearch productSearch){
        return productService.findAllWithQueries(productSearch);
    }

}

/*
id: 1,
    nome: 'Notebook Ultra',
    preco: 5499.99,
    imagemUrl: 'https://m.media-amazon.com/images/I/51qH44JtGtL.jpg',
 */
