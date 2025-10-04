package com.fiec.estoqueback.features.product.controllers;

import com.fiec.estoqueback.features.product.models.ProductMongo;
import com.fiec.estoqueback.features.product.repositories.ProductMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/mongo")
@AllArgsConstructor
public class ProductMongoController {

    private final ProductMongoRepository productMongoRepository;

    @PostMapping
    void insert(){
        ProductMongo productMongo = new ProductMongo();
        productMongo.setNome("Ola");
        productMongo.setClassificacoes(List.of("1", "quartenta", "Fiec"));
        productMongoRepository.insert(productMongo);
    }
}
