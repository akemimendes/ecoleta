package com.akemi.ecoleta.model.dto;

import java.io.Serializable;

import com.akemi.ecoleta.model.Veiculo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VeiculoDTO implements Serializable {

  public static final long serialVersionUID = 1L;

  private Long id_veiculo;

  @NotNull(message = "O campo PLACA é obrigatório")
  private String placa;

  @NotNull(message = "O campo MODELO é obrigatório")
  private String modelo;

  @NotNull(message = "O campo MARCA é obrigatório")
  private String marca;

  @NotNull(message="O campo ANO MODELO é obrigatório")
  private String ano_modelo;

  // convertendo para DTO
  public VeiculoDTO(Veiculo veiculo) {
    this.id_veiculo = veiculo.getId_veiculo();
    this.placa = veiculo.getPlaca();
    this.modelo = veiculo.getModelo();
    this.marca = veiculo.getMarca();
    this.ano_modelo = veiculo.getAno_modelo();
  }

}
