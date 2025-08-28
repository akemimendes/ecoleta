package com.akemi.ecoleta.model.enums;

public enum TipoPessoa {

     USUARIO(0, "ROLE_USUARIO"), COLABORADOR(1, "ROLE_COLABORADOR"), COOPERATIVA(2, "ROLE_COOPERATIVA"), INDUSTRIA(3, "ROLE_INDUSTRIA"), ADMIN(4, "ROLE_ADMIN");

     private Integer codigo;
     private String descricao;

     private TipoPessoa(Integer codigo, String descricao) {
          this.codigo = codigo;
          this.descricao = descricao;
     }

     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public String getDescricao() {
          return descricao;
     }

     public void setDescricao(String descricao) {
          this.descricao = descricao;
     }

     public static TipoPessoa toEnum(Integer cod) {
          if (cod == null) {
               return null;
          }
          for (TipoPessoa x : TipoPessoa.values()) {
               if (cod.equals(x.getCodigo())) {
                    return x;
               }
          }
          throw new IllegalArgumentException("Status inválido");

     }
}
