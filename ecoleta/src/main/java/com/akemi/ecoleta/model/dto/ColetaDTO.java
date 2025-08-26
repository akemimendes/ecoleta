package com.akemi.ecoleta.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ColetaDTO {

    private Long id_coleta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataSolicitacao=LocalDate.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataColeta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horaColeta;

    private Pessoa usuario;

    private Pessoa colaborador;

    private Pessoa cooperativa;

    private Veiculo veiculo;

    private Material material;

    private Status status;

    // convertendo para DTO
    public ColetaDTO(Coleta coleta) {
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
