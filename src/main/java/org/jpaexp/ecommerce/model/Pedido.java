package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jpaexp.ecommerce.listener.GerarNotaFiscalListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@EntityListeners({GerarNotaFiscalListener.class})
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;


    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

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

    @PrePersist
    public void prePersistir(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PrePersist");
        this.dataCriacao = LocalDateTime.now();
        calcularTotal();
    }
    @PostPersist
    public void postPersistir(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PostPersist");
    }

    @PreUpdate
    public void preAtualizar(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PreUpdate");
        this.dataUltimaAtualizacao = LocalDateTime.now();
        calcularTotal();
    }

    @PostUpdate
    public void postAtualizar(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PostUpdate");
    }

    @PreRemove
    public void preRemove(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PreRemove");
    }

    @PostRemove
    public void postRemove(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PostRemove");
    }

    @PostLoad
    public void postLoad(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>@PostLoad");
    }

    public void calcularTotal(){
        if(itens != null){
            total = itens.stream().map(ItemPedido::getPrecoProduto)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

        }
    }

}
