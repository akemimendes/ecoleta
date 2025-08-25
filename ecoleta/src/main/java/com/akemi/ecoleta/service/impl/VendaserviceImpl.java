package com.akemi.ecoleta.service.impl;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Venda;
import com.akemi.ecoleta.repository.VendaRepository;
import com.akemi.ecoleta.service.VendaService;

@Service
public class VendaserviceImpl implements VendaService {

    private final VendaRepository vendaRepository;

    public VendaserviceImpl(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public Page<Venda> getVenda(Pageable pageable) {
        return vendaRepository.findAll(pageable);
    }

    @Override
    public Venda getVendaById(long id_venda) {
        return vendaRepository.findById(id_venda).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Venda createVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    @Override
    public Venda updateVenda(Venda venda) {
        if (!vendaRepository.existsById(venda.getId_venda())) {
            throw new IllegalArgumentException("Venda não encontrada no sistema.");
        }
        return vendaRepository.save(venda);
    }

    @Override
    public void deleteVenda(long id_venda) {
        if (!vendaRepository.existsById(id_venda)) {
            throw new IllegalArgumentException("Venda não encontrada no sistema.");
        }
        vendaRepository.deleteById(id_venda);
    }

}
