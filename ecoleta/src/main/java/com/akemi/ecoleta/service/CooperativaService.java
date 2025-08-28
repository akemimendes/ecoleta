package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Cooperativa;
import com.akemi.ecoleta.model.dto.CooperativaDTO;

public interface CooperativaService {

     List<Cooperativa> getCooperativa();

    Cooperativa getCooperativaById(long id);

    Cooperativa createCooperativa(CooperativaDTO cooperativa);

    Cooperativa updateCooperativa(Long id, CooperativaDTO cooperativa);

    void deleteCooperativa(long id);

    boolean existsByCpfCnpj(String cnpj);

}
