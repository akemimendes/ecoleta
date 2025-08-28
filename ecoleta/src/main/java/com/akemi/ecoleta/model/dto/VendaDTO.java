package com.akemi.ecoleta.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.akemi.ecoleta.model.Industria;
import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.Venda;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class VendaDTO implements Serializable {

    public static final long serialVersionUID=1L;

    private Long id_venda;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_venda;

    private Material material;

    private float quantidade_kg;

    private Veiculo veiculo;

    private Industria industria;

    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_entrega;

    private float valor_total;

    //convertendo para DTO
    public VendaDTO(Venda venda) {
        this.id_venda = venda.getId_venda();
        this.data_venda = venda.getData_venda();
        this.material = venda.getMaterial();
        this.quantidade_kg = venda.getQuantidade_kg();
        this.veiculo = venda.getVeiculo();
        this.industria = venda.getIndustria();
        this.status = venda.getStatus();
        this.data_entrega = venda.getData_entrega();
        this.valor_total = venda.getValor_total();
    }

}
