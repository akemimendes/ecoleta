package com.akemi.ecoleta.model.dto;

import java.io.Serializable;

import com.akemi.ecoleta.model.Veiculo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VeiculoDTO implements Serializable {

  public static final long serialVersionUID = 1L;

  private Long id_veiculo;

  private String placa;

  private String modelo;

  private String marca;

  private String ano_modelo;

  
  //convertendo para DTO
  public VeiculoDTO(Veiculo veiculo) {
    this.id_veiculo = veiculo.getId_veiculo();
    this.placa = veiculo.getPlaca();
    this.modelo = veiculo.getModelo();
    this.marca = veiculo.getMarca();
    this.ano_modelo = veiculo.getAno_modelo();
  }
  

}
