package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
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
    public List<Coleta> getColeta() {
        return coletaRepository.findAll();
    }

    @Override
    public Coleta getColetaById(long id_coleta) {
        return coletaRepository.findById(id_coleta).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Coleta createColeta(ColetaDTO coleta) {
        return coletaRepository.save(new Coleta(coleta));
    }

    @Override
    public Coleta updateColeta(Long id,ColetaDTO coleta) {
        coleta.setId_coleta(id);
        if (!coletaRepository.existsById(coleta.getId_coleta())) {
            throw new IllegalArgumentException("Coleta não encontrada no sistema.");
        }
        return coletaRepository.save(new Coleta(coleta));
    }

    @Override
    public void deleteColeta(long id_coleta) {
        if (!coletaRepository.existsById(id_coleta)) {
            throw new IllegalArgumentException("Coleta não encontrada no sistema.");
        }
        coletaRepository.deleteById(id_coleta);
    }

    
}
