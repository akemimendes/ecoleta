package com.akemi.ecoleta.model;

import java.util.ArrayList;
import java.util.List;

import com.akemi.ecoleta.model.dto.ColaboradorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Colaborador extends Pessoa {

    public Colaborador() {
        super();
    }


    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<Coleta> coletas = new ArrayList<Coleta>();

    public Colaborador(ColaboradorDTO pessoa) {
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
        this.perfis = pessoa.getPerfis();
    }


    public List<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(List<Coleta> coletas) {
        this.coletas = coletas;
    }

    

}
