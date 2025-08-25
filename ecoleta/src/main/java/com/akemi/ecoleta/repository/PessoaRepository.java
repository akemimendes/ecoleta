package com.akemi.ecoleta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

     boolean existsByCpf_cnpj(String cpf_cnpj);

     Optional<Pessoa> findByCpf_cnpj(String cpf_cnpj);
     
}
