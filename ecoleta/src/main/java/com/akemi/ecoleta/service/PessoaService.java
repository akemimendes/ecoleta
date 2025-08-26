package com.akemi.ecoleta.service;

import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.dto.PessoaDTO;

import java.util.List;

public interface PessoaService {

    List<Pessoa> getPessoa();

    Pessoa getPessoaById(long id_usuario);

    Pessoa createPessoa(PessoaDTO usuario);

    Pessoa updatePessoa(PessoaDTO usuario);

    void deletePessoa(long id_usuario);

    boolean existsByCpfCnpj(String cpfCnpj);

}
