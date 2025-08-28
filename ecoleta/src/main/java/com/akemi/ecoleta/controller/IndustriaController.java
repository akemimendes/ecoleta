package com.akemi.ecoleta.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.akemi.ecoleta.model.Industria;
import com.akemi.ecoleta.model.dto.IndustriaDTO;
import com.akemi.ecoleta.service.IndustriaService;

@RestController
@RequestMapping("industrias")
public class IndustriaController {


    private final IndustriaService industriaService;

    public IndustriaController(IndustriaService industriaService) {
        this.industriaService = industriaService;
    }

    @GetMapping
    public ResponseEntity<List<IndustriaDTO>> findAll() {
        List<Industria> list = industriaService.getIndustria();
        List<IndustriaDTO> listDTO = list.stream().map(obj -> new IndustriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IndustriaDTO> findById(@PathVariable Integer id) {
        Industria industria = industriaService.getIndustriaById(id);
        return ResponseEntity.ok().body(new IndustriaDTO(industria));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<IndustriaDTO> deleteById(@PathVariable Integer id) {
        industriaService.deleteIndustria(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<IndustriaDTO> update(@PathVariable Long id, @RequestBody IndustriaDTO industria) {
        industriaService.updateIndustria(id, industria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(industria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<IndustriaDTO> create(@RequestBody IndustriaDTO industria) {
        industriaService.createIndustria(industria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(industria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

}
