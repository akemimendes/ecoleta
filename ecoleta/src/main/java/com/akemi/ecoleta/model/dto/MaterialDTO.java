package com.akemi.ecoleta.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.Venda;

import lombok.Data;

@Data
public class MaterialDTO {

    private Long id_material;

    private String descricao;

    private float valor;

    private float kg_disponivel;

    private List<Venda> vendas = new ArrayList<Venda>();

    private List<Coleta> coletas = new ArrayList<Coleta>();

    public MaterialDTO() {

    }

    public MaterialDTO(Material material) {
        this.descricao = material.getDescricao();
        this.valor = material.getValor();
        this.kg_disponivel = material.getKg_disponivel();
        this.vendas = material.getVendas();
        this.coletas = material.getColetas();
    }
}
