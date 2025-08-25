package com.akemi.ecoleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Coleta;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long>{

}
