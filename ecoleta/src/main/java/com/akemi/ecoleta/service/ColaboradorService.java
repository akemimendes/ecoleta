package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Colaborador;
import com.akemi.ecoleta.model.dto.ColaboradorDTO;

public interface ColaboradorService {

    List<Colaborador> getColaborador();

    Colaborador getColaboradorById(long id);

    Colaborador createColaborador(ColaboradorDTO colaborador);

    Colaborador updateColaborador(Long id, ColaboradorDTO colaborador);

    void deleteColaborador(long id);

    boolean existsByCpfCnpj(String cnpj);

}
