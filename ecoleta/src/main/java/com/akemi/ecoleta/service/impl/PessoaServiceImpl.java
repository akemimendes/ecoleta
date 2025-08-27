package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.dto.PessoaDTO;
import com.akemi.ecoleta.repository.PessoaRepository;
import com.akemi.ecoleta.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    @Autowired
	private PasswordEncoder encoder;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

    }

    @Override
    public List<Pessoa> getPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa getPessoaById(long id_usuario) {
        return pessoaRepository.findById(id_usuario).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Pessoa createPessoa(PessoaDTO usuario) {
        Pessoa novoUsuario= new Pessoa(usuario);
        novoUsuario.setSenha(encoder.encode(usuario.getSenha()));
        if (existsByCpfCnpj(usuario.getCpfCnpj())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema.");
        }
        return pessoaRepository.save(novoUsuario);
    }

    @Override
    public Pessoa updatePessoa(Long id,PessoaDTO usuario) {
        usuario.setId_usuario(id);
        if (!pessoaRepository.existsById(usuario.getId_usuario())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        Optional<Pessoa> p1 = pessoaRepository.findByCpfCnpj(usuario.getCpfCnpj());
        if (p1.get().getId_usuario() != usuario.getId_usuario()) {
            throw new DataIntegrityViolationException("O CPF já existe cadastrado para outro usuário");
        }

        return pessoaRepository.save(new Pessoa(usuario));
    }

    @Override
    public void deletePessoa(long id_usuario) {
        if (!pessoaRepository.existsById(id_usuario)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        pessoaRepository.deleteById(id_usuario);
    }

    @Override
    public boolean existsByCpfCnpj(String cpfCnpj) {
        return pessoaRepository.existsByCpfCnpj(cpfCnpj);
    }

}
