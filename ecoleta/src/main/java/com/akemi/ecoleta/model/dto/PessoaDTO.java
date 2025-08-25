package com.akemi.ecoleta.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.akemi.ecoleta.model.Coleta;
import com.akemi.ecoleta.model.Endereco;
import com.akemi.ecoleta.model.Pessoa;
import com.akemi.ecoleta.model.Venda;
import com.akemi.ecoleta.model.enums.TipoPessoa;
import lombok.Data;

@Data
public class PessoaDTO {

    private String cpf_cnpj;

    private String nome;

    private String email;

    private String senha;

    private Endereco endereco;

    private TipoPessoa tipoPessoa;

    private List<Coleta> coletas = new ArrayList<Coleta>();

    private List<Venda> vendas = new ArrayList<Venda>();

    public PessoaDTO(Pessoa pessoa) {
        this.cpf_cnpj = pessoa.getCpf_cnpj();

        this.nome = pessoa.getNome();

        this.email = pessoa.getEmail();

        this.senha = pessoa.getSenha();

        this.endereco = pessoa.getEndereco();

        this.tipoPessoa = pessoa.getTipoPessoa();

        this.coletas = pessoa.getColetas();

        this.vendas = pessoa.getVendas();
    }

}
