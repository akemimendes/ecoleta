package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.dto.ColetaDTO;


public interface ColetaService {

    List<Coleta> getColeta();

    Coleta getColetaById(long id_coleta);

    Coleta createColeta(ColetaDTO coleta);

    Coleta updateColeta(Long id,ColetaDTO coleta);

    void deleteColeta(long id_coleta);
}
