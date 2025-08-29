package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Industria;
import com.akemi.ecoleta.model.dto.IndustriaDTO;
import com.akemi.ecoleta.model.enums.TipoPessoa;
import com.akemi.ecoleta.repository.IndustriaRepository;
import com.akemi.ecoleta.service.IndustriaService;

@Service
public class IndustriaServiceImpl implements IndustriaService {

    private final IndustriaRepository industriaRepository;
    @Autowired
    private PasswordEncoder encoder;

    public IndustriaServiceImpl(IndustriaRepository industriaRepository) {
        this.industriaRepository = industriaRepository;

    }

    @Override
    public List<Industria> getIndustria() {
        return industriaRepository.findAll();
    }

    @Override
    public Industria getIndustriaById(long id_industria) {
        return industriaRepository.findById(id_industria).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Industria createIndustria(IndustriaDTO industria) {
        industria.getPerfis().add(3);
        Industria novoIndustria = new Industria(industria);
        novoIndustria.setSenha(encoder.encode(industria.getSenha()));
        novoIndustria.getPerfis().add(TipoPessoa.INDUSTRIA);
        if (existsByCpfCnpj(industria.getCpfCnpj())) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado no sistema.");
        }
        return industriaRepository.save(novoIndustria);
    }

    @Override
    public Industria updateIndustria(Long id, IndustriaDTO industria) {
        industria.setId(id);
        if (!industriaRepository.existsById(industria.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        Optional<Industria> p1 = industriaRepository.findByCpfCnpj(industria.getCpfCnpj());
        if (p1.get().getId() != industria.getId()) {
            throw new DataIntegrityViolationException("O CNPJ já existe cadastrado para outro usuário");
        }
        return industriaRepository.save(new Industria(industria));
    }

    @Override
    public void deleteIndustria(long id) {
        if (!industriaRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        industriaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCpfCnpj(String cnpj) {
        return industriaRepository.existsByCpfCnpj(cnpj);
    }

}
