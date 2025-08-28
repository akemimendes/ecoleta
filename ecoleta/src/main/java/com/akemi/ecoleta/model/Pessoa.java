package com.akemi.ecoleta.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.akemi.ecoleta.model.enums.TipoPessoa;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pessoa {

    public static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "cpfCnpj", nullable = false, unique = true)
    protected String cpfCnpj;

    @NotBlank(message = "E-mail não pode ficar em branco")
    @Email(message = "Formato de e-mail inválido")
    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "senha", nullable = false)
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    protected Set<Integer> perfis = new HashSet<>();

    @Column(name = "logradouro", nullable = false)
    protected String logradouro;

    @Column(name = "numero", nullable = false)
    protected int numero;

    @Column(name = "bairro", nullable = false)
    protected String bairro;

    @Column(name = "cidade", nullable = false)
    protected String cidade;

    @Column(name = "complemento")
    protected String complemento;

    @Column(name = "cep", nullable = false)
    protected String cep;

    @Column(name = "telefone", nullable = false)
    protected String telefone;

    @Column(name = "pontoReferencia")
    protected String pontoReferencia;

    public Set<TipoPessoa> getPerfis() {
        return perfis.stream().map(x -> TipoPessoa.toEnum(x)).collect(Collectors.toSet());
    }
}
