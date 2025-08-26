package com.akemi.ecoleta.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.repository.PessoaRepository;
import com.akemi.ecoleta.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

    }

    @Override
    public Page<Pessoa> getPessoa(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    @Override
    public Pessoa getPessoaById(long id_usuario) {
        return pessoaRepository.findById(id_usuario).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Pessoa createPessoa(Pessoa usuario) {
        if (usuario.getId_usuario() != null && pessoaRepository.existsById(usuario.getId_usuario())) {
            throw new IllegalArgumentException("O usuario ID já existe.");
        } 
        if (existsByCpfCnpj(usuario.getCpfCnpj())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema.");
        }
        return pessoaRepository.save(usuario);
    }

    @Override
    public Pessoa updatePessoa(Pessoa usuario) {
        if (!pessoaRepository.existsById(usuario.getId_usuario())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        Optional<Pessoa> p1 = pessoaRepository.findByCpfCnpj(usuario.getCpfCnpj());
        if (p1.get().getId_usuario() != usuario.getId_usuario()) {
            throw new DataIntegrityViolationException("O CPF já existe cadastrado para outro usuário");
        }

        return pessoaRepository.save(usuario);
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
