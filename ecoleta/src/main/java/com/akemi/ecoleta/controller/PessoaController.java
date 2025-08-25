package com.akemi.ecoleta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akemi.ecoleta.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

     private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
}
