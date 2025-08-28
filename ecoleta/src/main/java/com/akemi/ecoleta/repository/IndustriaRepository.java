package com.akemi.ecoleta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Industria;


@Repository
public interface IndustriaRepository  extends JpaRepository<Industria,Long>{

    boolean existsByCpfCnpj(String cnpj);

    Optional<Industria> findByCpfCnpj(String cnpj);

    Optional<Industria> findByEmail(String email);
}
