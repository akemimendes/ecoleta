package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.dto.VeiculoDTO;


public interface VeiculoService {

    List<Veiculo> getVeiculo();

    Veiculo getVeiculoById(long id_venda);

    Veiculo createVeiculo(VeiculoDTO veiculo);

    Veiculo updateVeiculo(Long id,VeiculoDTO veiculo);

    void deleteVeiculo(long id_veiculo);

    boolean existePlaca(String placa);
}
