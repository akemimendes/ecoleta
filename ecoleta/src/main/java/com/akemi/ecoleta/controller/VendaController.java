package com.akemi.ecoleta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akemi.ecoleta.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {


    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }
}
