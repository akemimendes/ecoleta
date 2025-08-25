package com.akemi.ecoleta.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.akemi.ecoleta.domain.model.enums.Status;
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
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coleta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataSolicitacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataColeta;

    @Column(name = "horaColeta", nullable = false)
    private LocalDateTime horaColeta;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Pessoa usuario;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id_usuario", nullable = false)
    private Pessoa colaborador;

    @ManyToOne
    @JoinColumn(name = "id_cooperativa", referencedColumnName = "id_usuario", nullable = false)
    private Pessoa cooperativa;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_material", referencedColumnName = "id_material", nullable = false)
    private Material material;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

}
