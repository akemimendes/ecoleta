package com.akemi.ecoleta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akemi.ecoleta.service.MaterialService;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

     private final MaterialService materialService;

    public MaterialController(MaterialService materialService){
        this.materialService=materialService;
    }
}
