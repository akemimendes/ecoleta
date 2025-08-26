package com.akemi.ecoleta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.dto.MaterialDTO;
import com.akemi.ecoleta.repository.MaterialRepository;
import com.akemi.ecoleta.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> getMaterial() {
        return materialRepository.findAll();
    }

    @Override
    public Material getMaterialById(long id_material) {
        return materialRepository.findById(id_material).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Material createMaterial(MaterialDTO material) {
        return materialRepository.save(new Material(material));
    }

    @Override
    public Material updateMaterial(Long id,MaterialDTO material) {
        material.setId_material(id);
        if (!materialRepository.existsById(material.getId_material())) {
            throw new IllegalArgumentException("Material não encontrado no sistema.");
        }
        return materialRepository.save(new Material(material));
    }

    @Override
    public void deleteMaterial(long id_material) {
        if (!materialRepository.existsById(id_material)) {
            throw new IllegalArgumentException("Material não encontrado no sistema.");
        }
        materialRepository.deleteById(id_material);
    }

}
