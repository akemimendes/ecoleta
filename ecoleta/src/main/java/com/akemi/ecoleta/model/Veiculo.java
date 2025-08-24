package com.akemi.ecoleta.model;

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
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_veiculo;
    @Column(name = "placa", nullable = false, unique = true)
    private String placa;
    @Column(name = "modelo", nullable = false)
    private String modelo;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "modelo", nullable = false)
    private String ano_modelo;

    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Coleta> coletas = new ArrayList<Coleta>();

    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Venda> vendas = new ArrayList<Venda>();

}
