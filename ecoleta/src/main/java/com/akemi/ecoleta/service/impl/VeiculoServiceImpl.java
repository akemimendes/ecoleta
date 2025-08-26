package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.dto.VeiculoDTO;
import com.akemi.ecoleta.repository.VeiculoRepository;
import com.akemi.ecoleta.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public List<Veiculo> getVeiculo() {
        return veiculoRepository.findAll();
    }

    @Override
    public Veiculo getVeiculoById(long id_venda) {
        return veiculoRepository.findById(id_venda).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Veiculo createVeiculo(VeiculoDTO veiculo) {
        if (veiculo.getId_veiculo() != null && veiculoRepository.existsById(veiculo.getId_veiculo())) {
            throw new IllegalArgumentException("O veículo ID já existe.");
        } else if (existePlaca(veiculo.getPlaca())) {
            throw new DataIntegrityViolationException("Placa já cadastrada no sistema.");
        }
        return veiculoRepository.save(new Veiculo(veiculo));
    }

    @Override
    public Veiculo updateVeiculo(Long id,VeiculoDTO veiculo) {
        veiculo.setId_veiculo(id);
        if (!veiculoRepository.existsById(veiculo.getId_veiculo())) {
            throw new IllegalArgumentException("Veículo não foi encontrado.");
        }
        Optional<Veiculo> v1 = veiculoRepository.findByPlaca(veiculo.getPlaca());
        if (v1.get().getId_veiculo() != veiculo.getId_veiculo()) {
            throw new DataIntegrityViolationException("A Placa já existe cadastrada para outro veículo");
        }
        return veiculoRepository.save(new Veiculo(veiculo));
    }

    @Override
    public void deleteVeiculo(long id_veiculo) {
        if (!veiculoRepository.existsById(id_veiculo)) {
            throw new IllegalArgumentException("Veículo não foi encontrado.");
        }
        veiculoRepository.deleteById(id_veiculo);
    }

    @Override
    public boolean existePlaca(String placa) {
        return veiculoRepository.existsByPlaca(placa);
    }

}
