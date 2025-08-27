package com.akemi.ecoleta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.dto.PessoaDTO;

@Service
public class DBService {

    @Autowired
    private PessoaService service;
    @Autowired
    private BCryptPasswordEncoder encoder;

   
    public void inicializar() {
        PessoaDTO admin = new PessoaDTO();
        admin.setCpfCnpj("054388908486");
        admin.setNome("Akemi Mendes");
        admin.setEmail("akemi@hotmail.com");
        admin.setSenha(encoder.encode("123"));
        admin.setLogradouro("prof jorge cahu");
        admin.setNumero(927);
        admin.setBairro("Piedade");
        admin.setCidade("Joaboatao");
        admin.setCep("54420080");
        admin.setTelefone("34628805");
        admin.getPerfis().add(5);
        service.createPessoa(admin);
    }
}
