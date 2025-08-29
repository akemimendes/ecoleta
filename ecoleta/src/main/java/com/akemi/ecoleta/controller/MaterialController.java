package com.akemi.ecoleta.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.akemi.ecoleta.model.Material;
import com.akemi.ecoleta.model.dto.MaterialDTO;
import com.akemi.ecoleta.service.MaterialService;


@PreAuthorize("hasAnyRole('ADMIN')")
@RestController
@RequestMapping("materiais")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> findAll() {
        List<Material> list = materialService.getMaterial();
        List<MaterialDTO> listDTO = list.stream().map(obj -> new MaterialDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> findById(@PathVariable Integer id) {
        Material material = materialService.getMaterialById(id);
        return ResponseEntity.ok().body(new MaterialDTO(material));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> deleteById(@PathVariable Integer id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> update(@PathVariable Long id, @RequestBody MaterialDTO material) {
        materialService.updateMaterial(id, material);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(material.getId_material())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<MaterialDTO> create(@RequestBody MaterialDTO material) {
        materialService.createMaterial(material);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(material.getId_material())
                .toUri();
        return ResponseEntity.created(uri).build();

    }
}
