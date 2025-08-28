package com.akemi.ecoleta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Cooperativa;


@Repository
public interface CooperativaRepository  extends JpaRepository<Cooperativa,Long>{

    boolean existsByCpfCnpj(String cnpj);

    Optional<Cooperativa> findByCpfCnpj(String cnpj);

    Optional<Cooperativa> findByEmail(String email);
}

