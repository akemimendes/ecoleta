package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Colaborador;
import com.akemi.ecoleta.model.dto.ColaboradorDTO;
import com.akemi.ecoleta.repository.ColaboradorRepository;
import com.akemi.ecoleta.service.ColaboradorService;


@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    @Autowired
    private PasswordEncoder encoder;

    public ColaboradorServiceImpl(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;

    }

    @Override
    public List<Colaborador> getColaborador() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador getColaboradorById(long id_Colaborador) {
        return colaboradorRepository.findById(id_Colaborador).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Colaborador createColaborador(ColaboradorDTO colaborador) {
        colaborador.getPerfis().add(1);
        Colaborador novoColaborador = new Colaborador(colaborador);
        novoColaborador.setSenha(encoder.encode(colaborador.getSenha()));
        if (existsByCpfCnpj(colaborador.getCpfCnpj())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema.");
        }
        return colaboradorRepository.save(novoColaborador);
    }

    @Override
    public Colaborador updateColaborador(Long id, ColaboradorDTO colaborador) {
        colaborador.setId(id);
        if (!colaboradorRepository.existsById(colaborador.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        Optional<Colaborador> p1 = colaboradorRepository.findByCpfCnpj(colaborador.getCpfCnpj());
        if (p1.get().getId() != colaborador.getId()) {
            throw new DataIntegrityViolationException("O CPF já existe cadastrado para outro usuário");
        }
        return colaboradorRepository.save(new Colaborador(colaborador));
    }

    @Override
    public void deleteColaborador(long id) {
        if (!colaboradorRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        colaboradorRepository.deleteById(id);
    }

    @Override
    public boolean existsByCpfCnpj(String cpf) {
        return colaboradorRepository.existsByCpfCnpj(cpf);
    }

}
