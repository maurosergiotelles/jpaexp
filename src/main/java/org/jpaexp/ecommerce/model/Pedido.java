package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal total;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<ItemPedido> itens = new ArrayList<>();

    public void addItem(ItemPedido itemPedido){
        itemPedido.setPedido(this);
        itens.add(itemPedido);
    }

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamentoCartao;



    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

}
