package com.fiec.estoqueback.features.user.models;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de representação (Bean) para mapear todas as 12 colunas do arquivo CSV.
 * Esta classe consolida campos de User, Admin, Standard e Guest.
 * Lombok (@Data) é usado para gerar Getters, Setters, etc., e @NoArgsConstructor
 * é crucial para que o OpenCSV consiga instanciar o objeto para o mapeamento.
 */
@Data
@NoArgsConstructor
public class UserCsvRepresentation {

    // ------------------------------------
    // Campos da entidade User
    // ------------------------------------

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "password", required = true)
    private String password;

    @CsvBindByName(column = "name")
    private String name;

    // O nível de acesso (ADMIN, STANDARD, GUEST) define quais campos extras serão preenchidos.
    @CsvBindByName(column = "accessLevel", required = true)
    private String accessLevel;

    // ------------------------------------
    // Campos de Admin/Standard
    // (Vazios para usuários GUEST)
    // ------------------------------------

    @CsvBindByName(column = "cnpj")
    private String cnpj;

    @CsvBindByName(column = "nomeDaEmpresa")
    private String nomeDaEmpresa;

    @CsvBindByName(column = "ramoAtuacao")
    private String ramoAtuacao;

    // ------------------------------------
    // Campos de Guest
    // (Vazios para usuários ADMIN/STANDARD)
    // ------------------------------------

    @CsvBindByName(column = "cpfOrCnpj")
    private String cpfOrCnpj; // Pode ser CPF ou CNPJ, dependendo do contexto do Guest

    @CsvBindByName(column = "city")
    private String city;

    @CsvBindByName(column = "zipCode")
    private String zipCode;

    @CsvBindByName(column = "number")
    private String number;
}
