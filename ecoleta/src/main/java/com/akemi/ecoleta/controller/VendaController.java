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

import com.akemi.ecoleta.model.Venda;
import com.akemi.ecoleta.model.dto.VendaDTO;
import com.akemi.ecoleta.service.VendaService;

import jakarta.validation.Valid;

@PreAuthorize("hasAnyRole('ADMIN')")
@RestController
@RequestMapping("vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

   
    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll() {
        List<Venda> list = vendaService.getVenda();
        List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','INDUSTRIA')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable Integer id) {
        Venda venda = vendaService.getVendaById(id);
        return ResponseEntity.ok().body(new VendaDTO(venda));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> deleteById(@PathVariable Integer id) {
        vendaService.deleteVenda(id);
        return ResponseEntity.noContent().build();
    }

    
    @PutMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable Long id,@Valid @RequestBody VendaDTO venda) {
        vendaService.updateVenda(id, venda);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venda.getId_venda())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN','INDUSTRIA')")
    @PostMapping
    public ResponseEntity<VendaDTO> create(@Valid @RequestBody VendaDTO venda) {
        vendaService.createVenda(venda);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venda.getId_venda())
                .toUri();
        return ResponseEntity.created(uri).build();

    }
}
