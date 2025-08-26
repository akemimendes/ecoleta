package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Venda;
import com.akemi.ecoleta.model.dto.VendaDTO;
import com.akemi.ecoleta.repository.VendaRepository;
import com.akemi.ecoleta.service.VendaService;

@Service
public class VendaserviceImpl implements VendaService {

    private final VendaRepository vendaRepository;

    public VendaserviceImpl(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public List<Venda> getVenda() {
        return vendaRepository.findAll();
    }

    @Override
    public Venda getVendaById(long id_venda) {
        return vendaRepository.findById(id_venda).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Venda createVenda(VendaDTO venda) {
        return vendaRepository.save(new Venda(venda));
    }

    @Override
    public Venda updateVenda(VendaDTO venda) {
        if (!vendaRepository.existsById(venda.getId_venda())) {
            throw new IllegalArgumentException("Venda não encontrada no sistema.");
        }
        return vendaRepository.save(new Venda(venda));
    }

    @Override
    public void deleteVenda(long id_venda) {
        if (!vendaRepository.existsById(id_venda)) {
            throw new IllegalArgumentException("Venda não encontrada no sistema.");
        }
        vendaRepository.deleteById(id_venda);
    }

}
