package com.fiec.estoqueback.features.product.models;


import com.fiec.estoqueback.features.user.models.Guest;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "products")
public class ProductMongo {

    // A anotação @Id mapeia o campo para o campo "_id" do MongoDB
    @Id
    private String id;

    private String nome;

    private List<String> classificacoes;


}
