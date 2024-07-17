package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedidoId;

    private StatusPagamento status;

    private String numero;


}
