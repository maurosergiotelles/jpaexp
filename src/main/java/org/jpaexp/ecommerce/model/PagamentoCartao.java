package org.jpaexp.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedidoId;

    private StatusPagamento status;

    private String numero;


}
