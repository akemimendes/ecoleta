package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Venda;
import com.akemi.ecoleta.model.dto.VendaDTO;

public interface VendaService {

    List<Venda> getVenda();

    Venda getVendaById(long id_venda);

    Venda createVenda(VendaDTO venda);

    Venda updateVenda(Long id,VendaDTO venda);

    void deleteVenda(long id_venda);
}
