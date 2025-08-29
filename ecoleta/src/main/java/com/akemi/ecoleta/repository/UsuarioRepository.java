package com.akemi.ecoleta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

     boolean existsByCpfCnpj(String cpf);

     Optional<Usuario> findByCpfCnpj(String cpf);

     
}
