package com.akemi.ecoleta.model;

import java.time.LocalDateTime;

import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_venda;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_venda;

    @ManyToOne
    @JoinColumn(name = "id_material", referencedColumnName = "id_material", nullable = false)
    private Material id_material;

    @Column(name = "quantida", nullable = false)
    private float quantidade_kg;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_industria", referencedColumnName = "id_usuario", nullable = false)
    private Pessoa industria;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_entrega;

    @Column(name = "valor_total", nullable = false)
    @Enumerated(EnumType.STRING)
    private float valor_total;

}
