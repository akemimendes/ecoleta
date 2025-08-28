package com.akemi.ecoleta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    boolean existsByCpfCnpj(String cpf);

    Optional<Colaborador> findByCpfCnpj(String cpf);

    Optional<Colaborador> findByEmail(String email);
}
