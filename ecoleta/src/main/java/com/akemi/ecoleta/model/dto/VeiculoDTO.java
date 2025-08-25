package com.akemi.ecoleta.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.Venda;

import lombok.Data;

@Data
public class VeiculoDTO {

    private String placa;

    private String modelo;

    private String marca;

    private String ano_modelo;

    private List<Coleta> coletas = new ArrayList<Coleta>();

    private List<Venda> vendas = new ArrayList<Venda>();

    public VeiculoDTO(Veiculo veiculo) {
       this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.marca = veiculo.getMarca();
        this.ano_modelo = veiculo.getAno_modelo();
        this.coletas = veiculo.getColetas();
        this.vendas = veiculo.getVendas();
    }

}
