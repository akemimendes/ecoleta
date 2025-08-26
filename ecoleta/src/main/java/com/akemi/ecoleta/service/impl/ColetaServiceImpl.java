package com.akemi.ecoleta.service.impl;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.dto.ColetaDTO;
import com.akemi.ecoleta.repository.ColetaRepository;
import com.akemi.ecoleta.service.ColetaService;

@Service
public class ColetaServiceImpl implements ColetaService {

    private final ColetaRepository coletaRepository;

    public ColetaServiceImpl(ColetaRepository coletaRepository) {
        this.coletaRepository = coletaRepository;
    }

    @Override
    public Page<Coleta> getColeta(Pageable pageable) {
        return coletaRepository.findAll(pageable);
    }

    @Override
    public Coleta getColetaById(long id_coleta) {
        return coletaRepository.findById(id_coleta).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Coleta createColeta(Coleta coleta) {
        return coletaRepository.save(coleta);
    }

    @Override
    public Coleta updateColeta(Coleta coleta) {
        if (!coletaRepository.existsById(coleta.getId_coleta())) {
            throw new IllegalArgumentException("Coleta não encontrada no sistema.");
        }
        return coletaRepository.save(coleta);
    }

    @Override
    public void deleteColeta(long id_coleta) {
        if (!coletaRepository.existsById(id_coleta)) {
            throw new IllegalArgumentException("Coleta não encontrada no sistema.");
        }
        coletaRepository.deleteById(id_coleta);
    }

    
}
