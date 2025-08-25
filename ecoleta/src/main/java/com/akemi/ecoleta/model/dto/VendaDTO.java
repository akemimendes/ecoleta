package com.akemi.ecoleta.model.dto;

import java.time.LocalDateTime;

import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
public class VendaDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_venda;

    private Material material;

    private float quantidade_kg;

    private Veiculo veiculo;

    private Pessoa industria;

    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_entrega;

    private float valor_total;

}
