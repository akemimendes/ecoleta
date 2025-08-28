package com.akemi.ecoleta.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.dto.UsuarioDTO;

@Service
public class DBService {

    @Autowired
    private UsuarioService service;
 

   
    public void inicializar() {
        UsuarioDTO admin = new UsuarioDTO();
        admin.setCpfCnpj("05438908486");
        admin.setNome("Akemi Mendes");
        admin.setEmail("akemi@hotmail.com");
        admin.setSenha("123");
        admin.setLogradouro("prof jorge cahu");
        admin.setNumero(927);
        admin.setBairro("Piedade");
        admin.setCidade("Joaboatao");
        admin.setCep("54420080");
        admin.setTelefone("34628805");
        admin.getPerfis().add(4);
        service.createUsuario(admin);
    }
}
