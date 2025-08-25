package com.akemi.ecoleta.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.domain.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

     boolean existsByPlaca(String placa);

     Optional<Veiculo> findByPlaca(String placa);
}
