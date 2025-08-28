package com.akemi.ecoleta.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CredenciaisDTO implements Serializable{

    public static final long serialVersionUID=1L;

    private String email;
    private String senha;
       

}
