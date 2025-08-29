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

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.dto.ColetaDTO;
import com.akemi.ecoleta.service.ColetaService;

import jakarta.validation.Valid;

@PreAuthorize("hasAnyRole('USUARIO')")
@RestController
@RequestMapping("coletas")
public class ColetaController {

    private final ColetaService coletaService;

    public ColetaController(ColetaService coletaService){
        this.coletaService=coletaService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ColetaDTO>> findAll() {
        List<Coleta> list = coletaService.getColeta();
        List<ColetaDTO> listDTO = list.stream().map(obj -> new ColetaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColetaDTO> findById(@PathVariable Integer id) {
        Coleta coleta = coletaService.getColetaById(id);
        return ResponseEntity.ok().body(new ColetaDTO(coleta));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ColetaDTO> deleteById(@PathVariable Integer id) {
        coletaService.deleteColeta(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ColetaDTO> update(@PathVariable Long id,@Valid @RequestBody ColetaDTO coleta) {
        coletaService.updateColeta(id, coleta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(coleta.getId_coleta())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<ColetaDTO> create(@Valid @RequestBody ColetaDTO coleta) {
        coletaService.createColeta(coleta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(coleta.getId_coleta())
                .toUri();
        return ResponseEntity.created(uri).build();

    }


}
