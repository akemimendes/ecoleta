package com.akemi.ecoleta.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.akemi.ecoleta.model.Colaborador;
import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.Cooperativa;
import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.Usuario;
import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ColetaDTO implements Serializable{

    public static final long serialVersionUID=1L;

    private Long id_coleta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataSolicitacao=LocalDate.now();

    @NotNull(message="O campo DATA DA COLETA é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataColeta;

    @NotNull(message="O campo HORA DA COLETA é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horaColeta;

    private Usuario usuario;

    private Colaborador colaborador;

    private Cooperativa cooperativa;

    private Veiculo veiculo;

    @NotNull(message="O campo MATERIAL é obrigatório")
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
