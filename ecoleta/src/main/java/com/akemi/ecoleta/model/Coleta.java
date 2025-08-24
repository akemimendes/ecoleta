package com.akemi.ecoleta.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.akemi.ecoleta.model.enums.Status;



public class Coleta {

    private LocalDate dataSolicitacao;
    private LocalDate dataColeta;
    private LocalDateTime horaColeta;
    private Pessoa usuario;
    private Pessoa colaborador;
    private Pessoa cooperativa;
    private Veiculo id_veiculo;
    private Material id_material;
    private Status status;

    //gets e sets 
    
    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }
    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
    public LocalDate getDataColeta() {
        return dataColeta;
    }
    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }
    public LocalDateTime getHoraColeta() {
        return horaColeta;
    }
    public void setHoraColeta(LocalDateTime horaColeta) {
        this.horaColeta = horaColeta;
    }
    public Pessoa getUsuario() {
        return usuario;
    }
    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }
    public Pessoa getColaborador() {
        return colaborador;
    }
    public void setColaborador(Pessoa colaborador) {
        this.colaborador = colaborador;
    }
    public Pessoa getCooperativa() {
        return cooperativa;
    }
    public void setCooperativa(Pessoa cooperativa) {
        this.cooperativa = cooperativa;
    }
    public Veiculo getId_veiculo() {
        return id_veiculo;
    }
    public void setId_veiculo(Veiculo id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
    public Material getId_material() {
        return id_material;
    }
    public void setId_material(Material id_material) {
        this.id_material = id_material;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    

}
