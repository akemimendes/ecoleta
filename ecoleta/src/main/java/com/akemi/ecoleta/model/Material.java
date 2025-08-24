package com.akemi.ecoleta.model;

public class Material {

    private long id_material;
    private String descricao;
    private float valor;
    private float kg_disponivel;

    //gets e sets
    
    public long getId_material() {
        return id_material;
    }
    public void setId_material(long id_material) {
        this.id_material = id_material;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getKg_disponivel() {
        return kg_disponivel;
    }
    public void setKg_disponivel(float kg_disponivel) {
        this.kg_disponivel = kg_disponivel;
    }

    

}
