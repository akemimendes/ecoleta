package com.akemi.ecoleta.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.enums.TipoPessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PessoaDTO {

    private Long id_usuario;

    private String cpfCnpj;

    private String nome;

    private String email;

    private String senha;

    private String logradouro;

    private int numero;

    private String bairro;

    private String cidade;

    private String complemento;

    private String cep;

    private String telefone;

    private String pontoReferencia;

    private  Set<Integer> perfis=new HashSet<>();

    // convertendo para DTO
    public PessoaDTO(Pessoa pessoa) {

        this.id_usuario = pessoa.getId_usuario();
        this.cpfCnpj = pessoa.getCpfCnpj();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.senha = pessoa.getSenha();
        this.logradouro = pessoa.getLogradouro();
        this.numero = pessoa.getNumero();
        this.bairro = pessoa.getBairro();
        this.cidade = pessoa.getCidade();
        this.complemento = pessoa.getComplemento();
        this.cep = pessoa.getCep();
        this.telefone = pessoa.getTelefone();
        this.pontoReferencia = pessoa.getPontoReferencia();
        addPerfil(TipoPessoa.ADMIN);
    }

    public void addPerfil(TipoPessoa perfis) {
        this.perfis.add(perfis.getCodigo());
    }
}
