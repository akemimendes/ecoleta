package com.akemi.ecoleta.model.dto;

import com.akemi.ecoleta.model.Material;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MaterialDTO {

    private Long id_material;

    private String descricao;

    private float valor;

    private float kg_disponivel;


    //convertendo para DTO
    public MaterialDTO(Material material) {
        this.id_material= material.getId_material();
        this.descricao = material.getDescricao();
        this.valor = material.getValor();
        this.kg_disponivel = material.getKg_disponivel();
    }
}
