package com.akemi.ecoleta.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

     boolean existsByCpf_cnpj(String cpf_cnpj);

     Optional<Pessoa> findByCpf_cnpj(String cpf_cnpj);
     
}
