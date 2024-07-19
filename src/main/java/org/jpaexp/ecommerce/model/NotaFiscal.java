package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String xml;

    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
