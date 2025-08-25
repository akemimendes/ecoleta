package com.akemi.ecoleta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akemi.ecoleta.domain.model.Venda;

public interface VendaService {

    Page<Venda> getVenda(Pageable pageable);

    Venda getVendaById(long id_venda);

    Venda createVenda(Venda venda);

    Venda updateVenda(Venda venda);

    void deleteVenda(long id_venda);
}
