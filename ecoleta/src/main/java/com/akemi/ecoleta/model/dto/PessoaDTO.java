package com.akemi.ecoleta.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PessoaDTO implements Serializable{

    public static final long serialVersionUID = 1L;

    protected Long id;

    protected String cpfCnpj;

    protected String nome;

    protected String email;

    protected String senha;

    protected String logradouro;

    protected int numero;

    protected String bairro;

    protected String cidade;

    protected String complemento;

    protected String cep;

    protected String telefone;

    protected String pontoReferencia;

    protected Set<Integer> perfis = new HashSet<>();

}
