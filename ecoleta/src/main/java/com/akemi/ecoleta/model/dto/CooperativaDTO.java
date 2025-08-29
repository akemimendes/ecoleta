package com.akemi.ecoleta.model.dto;

import com.akemi.ecoleta.model.Cooperativa;


public class CooperativaDTO extends PessoaDTO {


    public CooperativaDTO() {
        super();
    }

    // convertendo para DTO
    public CooperativaDTO(Cooperativa pessoa) {

        this.id = pessoa.getId();
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
    }

  

}
