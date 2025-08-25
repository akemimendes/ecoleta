package com.akemi.ecoleta.model;

import java.util.ArrayList;
import java.util.List;

import com.akemi.ecoleta.model.dto.PessoaDTO;
import com.akemi.ecoleta.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    private String cpf_cnpj;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Coleta> coletas = new ArrayList<Coleta>();

    @OneToMany(mappedBy = "industria", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Venda> vendas = new ArrayList<Venda>();

    public Pessoa(PessoaDTO pessoa) {
        this.id_usuario = pessoa.getId_usuario();
        this.cpf_cnpj = pessoa.getCpf_cnpj();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.senha = pessoa.getSenha();
        this.endereco = pessoa.getEndereco();
        this.tipoPessoa = pessoa.getTipoPessoa();
        this.coletas = pessoa.getColetas();
        this.vendas = pessoa.getVendas();
    }

}
