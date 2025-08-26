package com.akemi.ecoleta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akemi.ecoleta.service.ColetaService;

@RestController
@RequestMapping("coletas")
public class ColetaController {

    private final ColetaService coletaService;

    public ColetaController(ColetaService coletaService){
        this.coletaService=coletaService;
    }


}
