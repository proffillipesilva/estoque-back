package com.fiec.estoqueback.features.product.models;

import com.fiec.estoqueback.features.product.models.enums.TipoMedida;
import com.fiec.estoqueback.features.user.models.Guest;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String nome;

    private String descricao;

    private Double preco;

    private Double quantidade;

    private TipoMedida tipoMedida;

    private String imagem;

    private Date dataDeSubmissao;

    private Long lote;

    @CreationTimestamp
    private Date dataDeCriacao;


    private String guestName;


}
