package com.akemi.ecoleta.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.akemi.ecoleta.model.dto.PessoaDTO;
import com.akemi.ecoleta.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pessoa {

    @SuppressWarnings("unused")
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "cpfCnpj", nullable = false, unique = true)
    private String cpfCnpj;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    private Set<Integer> perfis = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<Coleta> coletas = new ArrayList<Coleta>();

    @OneToMany(mappedBy = "industria", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<Venda> vendas = new ArrayList<Venda>();

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "pontoReferencia")
    private String pontoReferencia;

    public Pessoa(PessoaDTO pessoa) {
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

    public Set<TipoPessoa> getPerfis() {
        return perfis.stream().map(x -> TipoPessoa.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(TipoPessoa perfis) {
        this.perfis.add(perfis.getCodigo());
    }

}
