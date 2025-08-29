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

import com.akemi.ecoleta.model.Cooperativa;
import com.akemi.ecoleta.model.dto.CooperativaDTO;
import com.akemi.ecoleta.service.CooperativaService;


@PreAuthorize("hasAnyRole('ADMIN')")
@RestController
@RequestMapping("cooperativas")
public class CooperativaController {


    private final CooperativaService cooperativaService;

    public CooperativaController(CooperativaService cooperativaService) {
        this.cooperativaService = cooperativaService;
    }

    @GetMapping
    public ResponseEntity<List<CooperativaDTO>> findAll() {
        List<Cooperativa> list = cooperativaService.getCooperativa();
        List<CooperativaDTO> listDTO = list.stream().map(obj -> new CooperativaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COOPERATIVA')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CooperativaDTO> findById(@PathVariable Integer id) {
        Cooperativa cooperativa = cooperativaService.getCooperativaById(id);
        return ResponseEntity.ok().body(new CooperativaDTO(cooperativa));
    }

    @PreAuthorize("hasAnyRole('ADMIN','COOPERATIVA')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CooperativaDTO> deleteById(@PathVariable Integer id) {
        cooperativaService.deleteCooperativa(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN','COOPERATIVA')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CooperativaDTO> update(@PathVariable Long id, @RequestBody CooperativaDTO cooperativa) {
        cooperativaService.updateCooperativa(id, cooperativa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cooperativa.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN','COOPERATIVA')")
    @PostMapping
    public ResponseEntity<CooperativaDTO> create(@RequestBody CooperativaDTO cooperativa) {
        cooperativaService.createCooperativa(cooperativa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cooperativa.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

}
