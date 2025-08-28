package com.akemi.ecoleta.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.akemi.ecoleta.model.dto.ColetaDTO;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @SuppressWarnings("unused")
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coleta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataSolicitacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataColeta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horaColeta;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
    private Colaborador colaborador;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_cooperativa", referencedColumnName = "id")
    private Cooperativa cooperativa;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_material", referencedColumnName = "id_material", nullable = false)
    private Material material;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Coleta(ColetaDTO coleta) {
        this.id_coleta = coleta.getId_coleta();
        this.dataSolicitacao = coleta.getDataSolicitacao();
        this.dataColeta = coleta.getDataColeta();
        this.horaColeta = coleta.getHoraColeta();
        this.usuario = coleta.getUsuario();
        this.colaborador = coleta.getColaborador();
        this.cooperativa = coleta.getCooperativa();
        this.veiculo = coleta.getVeiculo();
        this.material = coleta.getMaterial();
        this.status = coleta.getStatus();
    }

}
