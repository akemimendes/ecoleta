package com.akemi.ecoleta.service;

import com.akemi.ecoleta.model.Usuario;
import com.akemi.ecoleta.model.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuario();

    Usuario getUsuarioById(long id);

    Usuario createUsuario(UsuarioDTO usuario);

    Usuario updateUsuario(Long id, UsuarioDTO usuario);

    void deleteUsuario(long id);

    boolean existsByCpfCnpj(String cpf);

}
