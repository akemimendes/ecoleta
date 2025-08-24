package com.akemi.ecoleta.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akemi.ecoleta.domain.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long>{

}
