package com.akemi.ecoleta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.dto.ColetaDTO;

public interface ColetaService {

    Page<Coleta> getColeta(Pageable pageable);

    Coleta getColetaById(long id_coleta);

    Coleta createColeta(ColetaDTO coleta);

    Coleta updateColeta(ColetaDTO coleta);

    void deleteColeta(long id_coleta);
}
