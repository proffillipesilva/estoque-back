package com.fiec.estoqueback.features.product.repositories.impl;

import com.fiec.estoqueback.features.product.models.Product;
import com.fiec.estoqueback.features.product.models.dto.ProductSearch;
import com.fiec.estoqueback.features.product.models.dto.SortOrder;
import com.fiec.estoqueback.features.product.repositories.ProductCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    private final EntityManager entityManager;

    // Construtor para injeção do EntityManager
    public ProductCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Busca produtos de forma customizada usando a Criteria API do JPA.
     * @param productSearch Objeto com os critérios de busca e ordenação.
     * @return Lista de produtos que atendem aos critérios.
     */
    public List<Product> findProducts(ProductSearch productSearch) {

        // 1. Inicialização da Criteria API
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class); // Define a entidade raiz (FROM Product p)

        List<Predicate> predicates = new ArrayList<>();

        // 2. Constrói as Cláusulas WHERE (Predicates) dinamicamente

        // Critério: Nome (Busca parcial, case-insensitive LIKE)
        if (productSearch.getNome() != null && !productSearch.getNome().trim().isEmpty()) {
            // cb.like(cb.upper(product.get("nome")), "%NOME%")
            Predicate nomePredicate = cb.like(
                    cb.upper(product.get("nome")),
                    "%" + productSearch.getNome().toUpperCase().trim() + "%"
            );
            predicates.add(nomePredicate);
        }

        // Critério: Preço (Busca por preço exato)
        if (productSearch.getPreco() != null) {
            // cb.equal(product.get("preco"), preco)
            Predicate precoPredicate = cb.equal(product.get("preco"), productSearch.getPreco());
            predicates.add(precoPredicate);
        }

        // Critério: Tipo de Medida
        if (productSearch.getTipoMedida() != null) {
            // cb.equal(product.get("tipoMedida"), tipoMedida)
            Predicate tipoMedidaPredicate = cb.equal(product.get("tipoMedida"), productSearch.getTipoMedida());
            predicates.add(tipoMedidaPredicate);
        }

        // Combina todas as condições com AND
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        // 3. Constrói a Cláusula ORDER BY dinamicamente
        String sortBy = productSearch.getSortBy();
        SortOrder sortOrder = productSearch.getSortOrder() != null ? productSearch.getSortOrder() : SortOrder.ASC;

        if (sortBy != null && !sortBy.trim().isEmpty()) {
            // Garantir que a string de ordenação mapeia para o campo correto
            String safeSortBy = getSafeSortField(sortBy);

            Order order;
            if (sortOrder == SortOrder.DESC) {
                // cb.desc(product.get(safeSortBy))
                order = cb.desc(product.get(safeSortBy));
            } else {
                // cb.asc(product.get(safeSortBy))
                order = cb.asc(product.get(safeSortBy));
            }

            cq.orderBy(order);
        } else {
            // Ordenação default
            cq.orderBy(cb.asc(product.get("id")));
        }

        // 4. Cria e executa a TypedQuery
        TypedQuery<Product> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    // Método auxiliar para mapear/validar o campo de ordenação (segurança)
    private String getSafeSortField(String sortBy) {
        // Exemplo: Mapear nomes de campos da ProductSearch para a entidade Product
        switch (sortBy.toLowerCase()) {
            case "nome":
                return "nome";
            case "preco":
                return "preco";
            // Adicione outros campos de ordenação válidos
            case "id":
            default:
                return "id";
        }
    }
}
