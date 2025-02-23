package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
//@EqualsAndHashCode(of = {"id"})
@IdClass(ItemPedidoId.class)
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Id
    @Column(name = "produto_id")
    private Integer produtoId;




    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", insertable = false,updatable = false)
    private Produto produto;




    @Column(name = "preco_produto")
    private BigDecimal precoProduto;

    private Integer quantidade;
}