package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Usuario;
import com.akemi.ecoleta.model.dto.UsuarioDTO;
import com.akemi.ecoleta.model.enums.TipoPessoa;
import com.akemi.ecoleta.repository.UsuarioRepository;
import com.akemi.ecoleta.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder encoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }

    @Override
    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario createUsuario(UsuarioDTO usuario) {
        Usuario novoUsuario = new Usuario(usuario);
        novoUsuario.setSenha(encoder.encode(usuario.getSenha()));
        novoUsuario.getPerfis().add(TipoPessoa.USUARIO);
        if (existsByCpfCnpj(usuario.getCpfCnpj())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema.");
        }
        return usuarioRepository.save(novoUsuario);
    }

    @Override
    public Usuario updateUsuario(Long id, UsuarioDTO usuario) {
        usuario.setId(id);
        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        Optional<Usuario> p1 = usuarioRepository.findByCpfCnpj(usuario.getCpfCnpj());
        if (p1.get().getId() != usuario.getId()) {
            throw new DataIntegrityViolationException("O CPF já existe cadastrado para outro usuário");
        }
        return usuarioRepository.save(new Usuario(usuario));
    }

    @Override
    public void deleteUsuario(long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean existsByCpfCnpj(String cpf) {
        return usuarioRepository.existsByCpfCnpj(cpf);
    }

}
