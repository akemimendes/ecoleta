package com.akemi.ecoleta.model;

import java.time.LocalDateTime;

import com.akemi.ecoleta.model.dto.VendaDTO;
import com.akemi.ecoleta.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_venda;

    @ManyToOne
    @JoinColumn(name = "id_material", referencedColumnName = "id_material", nullable = false)
    private Material material;

    @Column(name = "quantidade", nullable = false, scale = 2)
    private float quantidade_kg;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_industria", referencedColumnName = "id_usuario", nullable = false)
    private Pessoa industria;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime data_entrega;

    @Column(name = "valor_total", nullable = false, scale = 2)
    private float valor_total;

    public Venda(VendaDTO venda) {
        this.id_venda = venda.getId_venda();
        this.data_venda = venda.getData_venda();
        this.material = venda.getMaterial();
        this.quantidade_kg = venda.getQuantidade_kg();
        this.veiculo = venda.getVeiculo();
        this.industria = venda.getIndustria();
        this.status = venda.getStatus();
        this.data_entrega = venda.getData_entrega();
        this.valor_total = venda.getValor_total();
    }

}
