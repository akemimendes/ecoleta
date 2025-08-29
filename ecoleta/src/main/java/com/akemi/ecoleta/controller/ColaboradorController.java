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

import com.akemi.ecoleta.model.Colaborador;
import com.akemi.ecoleta.model.dto.ColaboradorDTO;
import com.akemi.ecoleta.service.ColaboradorService;

@PreAuthorize("hasAnyRole('ADMIN')")
@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {


    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> findAll() {
        List<Colaborador> list = colaboradorService.getColaborador();
        List<ColaboradorDTO> listDTO = list.stream().map(obj -> new ColaboradorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> findById(@PathVariable Integer id) {
        Colaborador colaborador = colaboradorService.getColaboradorById(id);
        return ResponseEntity.ok().body(new ColaboradorDTO(colaborador));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> deleteById(@PathVariable Integer id) {
        colaboradorService.deleteColaborador(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> update(@PathVariable Long id, @RequestBody ColaboradorDTO colaborador) {
        colaboradorService.updateColaborador(id, colaborador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(colaborador.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> create(@RequestBody ColaboradorDTO colaborador) {
        colaboradorService.createColaborador(colaborador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(colaborador.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

}
