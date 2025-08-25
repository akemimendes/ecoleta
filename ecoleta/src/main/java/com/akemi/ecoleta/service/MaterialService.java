package com.akemi.ecoleta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akemi.ecoleta.domain.model.Material;


public interface MaterialService {

    Page<Material> getMaterial(Pageable pageable);

    Material getMaterialById(long id_material);

    Material createMaterial(Material material);

    Material updateMaterial(Material material);

    void deleteMaterial(long id_material);

}
