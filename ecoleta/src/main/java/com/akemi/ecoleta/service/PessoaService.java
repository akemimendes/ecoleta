package com.akemi.ecoleta.service;

import com.akemi.ecoleta.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    Page<Pessoa> getPessoa(Pageable pageable);

    Pessoa getPessoaById(long id_usuario);

    Pessoa createPessoa(Pessoa usuario);

    Pessoa updatePessoa(Pessoa usuario);

    void deletePessoa(long id_usuario);

     boolean existsByCpf_cnpj(String cpf_cnpj);

}
