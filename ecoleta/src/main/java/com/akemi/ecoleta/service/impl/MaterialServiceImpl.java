package com.akemi.ecoleta.service.impl;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.domain.model.Material;
import com.akemi.ecoleta.domain.repository.MaterialRepository;
import com.akemi.ecoleta.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Page<Material> getMaterial(Pageable pageable) {
        return materialRepository.findAll(pageable);
    }

    @Override
    public Material getMaterialById(long id_material) {
        return materialRepository.findById(id_material).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material updateMaterial(Material material) {
        if (!materialRepository.existsById(material.getId_material())) {
            throw new IllegalArgumentException("Material não encontrado no sistema.");
        }
        return materialRepository.save(material);
    }

    @Override
    public void deleteMaterial(long id_material) {
        if (!materialRepository.existsById(id_material)) {
            throw new IllegalArgumentException("Material não encontrado no sistema.");
        }
        materialRepository.deleteById(id_material);
    }

}
