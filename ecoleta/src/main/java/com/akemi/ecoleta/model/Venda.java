package com.akemi.ecoleta.model;

import java.time.LocalDateTime;

import com.akemi.ecoleta.model.enums.Status;

public class Venda {

    private LocalDateTime data_venda;
    private Material id_material;
    private float quantidade_kg;
    private Veiculo id_veiculo;
    private Pessoa id_industria;
    private Status status;
    private LocalDateTime data_entrega;
    private float valor_total;

    //gets e sets 
    
    public LocalDateTime getData_venda() {
        return data_venda;
    }
    public void setData_venda(LocalDateTime data_venda) {
        this.data_venda = data_venda;
    }
    public Material getId_material() {
        return id_material;
    }
    public void setId_material(Material id_material) {
        this.id_material = id_material;
    }
    public float getQuantidade_kg() {
        return quantidade_kg;
    }
    public void setQuantidade_kg(float quantidade_kg) {
        this.quantidade_kg = quantidade_kg;
    }
    public Veiculo getId_veiculo() {
        return id_veiculo;
    }
    public void setId_veiculo(Veiculo id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
    public Pessoa getId_industria() {
        return id_industria;
    }
    public void setId_industria(Pessoa id_industria) {
        this.id_industria = id_industria;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDateTime getData_entrega() {
        return data_entrega;
    }
    public void setData_entrega(LocalDateTime data_entrega) {
        this.data_entrega = data_entrega;
    }
    public float getValor_total() {
        return valor_total;
    }
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }


    
    

}
