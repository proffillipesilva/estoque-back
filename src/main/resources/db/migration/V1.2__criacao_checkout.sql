-- Cria a tabela Checkout
CREATE TABLE checkout (
    -- O 'id' é a chave primária. Mapeia para @Id e @GeneratedValue(strategy = GenerationType.UUID).
    -- Usamos UUID para compatibilidade com a estratégia Java.
    id binary(16) PRIMARY KEY NOT NULL,

    -- Chave estrangeira para a tabela User. Mapeia para @ManyToOne private User user.
    -- Assumindo que a chave primária da tabela 'user' seja 'id' do tipo UUID.
    -- Garante que o campo não pode ser atualizado (updatable = false) e não é nulo (nullable = false).
    user_id binary(16) NOT NULL REFERENCES user(id),

    -- Chave estrangeira para a tabela Product. Mapeia para @ManyToOne private Product product.
    -- Assumindo que a chave primária da tabela 'product' seja 'id' do tipo UUID.
    product_id binary(16) NOT NULL REFERENCES product(id),

    -- Coluna 'preco'. Mapeia para private Double preco.
    preco NUMERIC(10, 2), -- Usando NUMERIC para precisão monetária (ajuste a precisão conforme necessário)

    -- Coluna 'quantidade'. Mapeia para private Long quantidade.
    quantidade BIGINT,

    -- Coluna 'checkoutDate'. Mapeia para @CreationTimestamp private Date checkoutDate.
    -- Usamos TIMESTAMP WITH TIME ZONE ou DATETIME e definimos o valor padrão/inserido pelo banco.
    checkout_date datetime(6) DEFAULT NULL
);