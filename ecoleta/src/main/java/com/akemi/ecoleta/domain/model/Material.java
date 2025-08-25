package com.akemi.ecoleta.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_material;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false, scale = 2)
    private float valor;

    @Column(name = "kg_disponivel", scale  = 2)
    private float kg_disponivel;

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Venda> vendas = new ArrayList<Venda>();

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Coleta> coletas = new ArrayList<Coleta>();
}
