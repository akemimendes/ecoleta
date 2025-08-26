package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.dto.MaterialDTO;


public interface MaterialService {

    List<Material> getMaterial();

    Material getMaterialById(long id_material);

    Material createMaterial(MaterialDTO material);

    Material updateMaterial(Long id,MaterialDTO material);

    void deleteMaterial(long id_material);

}
