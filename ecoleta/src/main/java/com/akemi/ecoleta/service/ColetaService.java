package com.akemi.ecoleta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akemi.ecoleta.model.Coleta;

public interface ColetaService {

    Page<Coleta> getColeta(Pageable pageable);

    Coleta getColetaById(long id_coleta);

    Coleta createColeta(Coleta coleta);

    Coleta updateColeta(Coleta coleta);

    void deleteColeta(long id_coleta);
}
