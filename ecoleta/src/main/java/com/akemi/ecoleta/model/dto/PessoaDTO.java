package com.akemi.ecoleta.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PessoaDTO implements Serializable{

    public static final long serialVersionUID = 1L;

    protected Long id;

    @NotNull(message="O campo CPF/CNPJ é obrigatório")
    protected String cpfCnpj;

    @NotNull(message="O campo NOME é obrigatório")
    protected String nome;

    @Email(message = "Email inválido")
    @NotNull(message="O campo EMAIL é obrigatório")
    protected String email;

    @NotNull(message="O campo SENHA é obrigatório")
    protected String senha;

    @NotNull(message="O campo LOGRADOURO é obrigatório")
    protected String logradouro;

    protected int numero;

    @NotNull(message="O campo BAIRRO é obrigatório")
    protected String bairro;

    @NotNull(message="O campo CIDADE é obrigatório")
    protected String cidade;

    protected String complemento;

    @NotNull(message="O campo CEP é obrigatório")
    protected String cep;

    @NotNull(message="O campo TELEFONE é obrigatório")
    protected String telefone;

    protected String pontoReferencia;

    protected Set<Integer> perfis = new HashSet<>();

}
