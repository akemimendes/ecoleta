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

import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.dto.VeiculoDTO;
import com.akemi.ecoleta.service.VeiculoService;

import jakarta.validation.Valid;

@PreAuthorize("hasAnyRole('ADMIN')")
@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    
    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        List<Veiculo> list = veiculoService.getVeiculo();
        List<VeiculoDTO> listDTO = list.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.getVeiculoById(id);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> deleteById(@PathVariable Integer id) {
        veiculoService.deleteVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id,@Valid @RequestBody VeiculoDTO veiculo) {
        veiculoService.updateVeiculo(id,veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getId_veiculo())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO veiculo) {
        veiculoService.createVeiculo(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getId_veiculo())
                .toUri();
        return ResponseEntity.created(uri).build();

    }
}
