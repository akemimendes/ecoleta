package com.akemi.ecoleta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akemi.ecoleta.model.Veiculo;


public interface VeiculoService {

    Page<Veiculo> getVeiculo(Pageable pageable);

    Veiculo getVeiculoById(long id_venda);

    Veiculo createVeiculo(Veiculo veiculo);

    Veiculo updateVeiculo(Veiculo veiculo);

    void deleteVeiculo(long id_veiculo);

    boolean existePlaca(String placa);
}
