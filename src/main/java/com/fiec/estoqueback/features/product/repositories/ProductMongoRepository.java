package com.fiec.estoqueback.features.product.repositories;

import com.fiec.estoqueback.features.product.models.ProductMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<ProductMongo, String> {
}
