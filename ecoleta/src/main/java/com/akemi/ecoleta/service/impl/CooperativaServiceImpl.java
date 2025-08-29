package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Cooperativa;
import com.akemi.ecoleta.model.dto.CooperativaDTO;
import com.akemi.ecoleta.repository.CooperativaRepository;
import com.akemi.ecoleta.service.CooperativaService;

@Service
public class CooperativaServiceImpl implements CooperativaService {

    private final CooperativaRepository cooperativaRepository;
    @Autowired
    private PasswordEncoder encoder;

    public CooperativaServiceImpl(CooperativaRepository cooperativaRepository) {
        this.cooperativaRepository = cooperativaRepository;

    }

    @Override
    public List<Cooperativa> getCooperativa() {
        return cooperativaRepository.findAll();
    }

    @Override
    public Cooperativa getCooperativaById(long id_cooperativa) {
        return cooperativaRepository.findById(id_cooperativa).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cooperativa createCooperativa(CooperativaDTO cooperativa) {
        cooperativa.getPerfis().add(2);
        Cooperativa novoCooperativa = new Cooperativa(cooperativa);
        novoCooperativa.setSenha(encoder.encode(cooperativa.getSenha()));
        if (existsByCpfCnpj(cooperativa.getCpfCnpj())) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado no sistema.");
        }
        return cooperativaRepository.save(novoCooperativa);
    }

    @Override
    public Cooperativa updateCooperativa(Long id, CooperativaDTO cooperativa) {
        cooperativa.setId(id);
        if (!cooperativaRepository.existsById(cooperativa.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        Optional<Cooperativa> p1 = cooperativaRepository.findByCpfCnpj(cooperativa.getCpfCnpj());
        if (p1.isPresent()) {
            if (p1.get().getId() != cooperativa.getId()) {
                throw new DataIntegrityViolationException("O CNPJ já existe cadastrado para outro usuário");
            }
        }
        return cooperativaRepository.save(new Cooperativa(cooperativa));
    }

    @Override
    public void deleteCooperativa(long id) {
        if (!cooperativaRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        cooperativaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCpfCnpj(String cnpj) {
        return cooperativaRepository.existsByCpfCnpj(cnpj);
    }

}
