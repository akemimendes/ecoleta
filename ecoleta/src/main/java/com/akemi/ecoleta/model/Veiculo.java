package com.akemi.ecoleta.model;

public class Veiculo {

    private long id_veiculo;
    private String placa;
    private String modelo;
    private String marca;
    private String ano_modelo;

     //gets e sets
     
    public long getId_veiculo() {
        return id_veiculo;
    }
    public void setId_veiculo(long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getAno_modelo() {
        return ano_modelo;
    }
    public void setAno_modelo(String ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

   

    

}
