package com.akemi.ecoleta.model.dto;

import com.akemi.ecoleta.model.Endereco;
import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.enums.TipoPessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PessoaDTO {

    private Long id_usuario;

    private String cpfCnpj;

    private String nome;

    private String email;

    private String senha;

    private Endereco endereco;

    private TipoPessoa tipoPessoa;


    //convertendo para DTO
    public PessoaDTO(Pessoa pessoa) {

        this.id_usuario = pessoa.getId_usuario();
        this.cpfCnpj = pessoa.getCpfCnpj();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.senha = pessoa.getSenha();
        this.endereco = pessoa.getEndereco();
        this.tipoPessoa = pessoa.getTipoPessoa();
    }

}
