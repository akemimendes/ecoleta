package com.akemi.ecoleta.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ColetaDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataSolicitacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataColeta;

    private LocalDateTime horaColeta;

    private Pessoa usuario;

    private Pessoa colaborador;

    private Pessoa cooperativa;

    private Veiculo veiculo;

    private Material material;

    private Status status;

    public ColetaDTO() {

    }

    public ColetaDTO(Coleta coleta) {
        this.dataSolicitacao = coleta.getDataSolicitacao();
        this.dataColeta = coleta.getDataColeta();
        this.horaColeta = coleta.getHoraColeta();
        this.usuario = coleta.getUsuario();
        this.colaborador=coleta.getColaborador();
        this.cooperativa=coleta.getCooperativa();
        this.veiculo=coleta.getVeiculo();
        this.material=coleta.getMaterial();
        this.status=coleta.getStatus();
    }

   

}
