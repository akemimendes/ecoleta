package com.akemi.ecoleta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akemi.ecoleta.model.Veiculo;
import com.akemi.ecoleta.model.dto.VeiculoDTO;
import com.akemi.ecoleta.service.VeiculoService;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@RequestBody VeiculoDTO veiculo){
       Veiculo novoVeiculo=new Veiculo(veiculo);
       veiculoService.createVeiculo(novoVeiculo);
       return ResponseEntity.status(HttpStatus.OK).body(new VeiculoDTO(novoVeiculo));
    }
}
