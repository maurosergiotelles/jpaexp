package org.jpaexp.ecommerce.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.jpaexp.ecommerce.model.Pedido;
import org.jpaexp.ecommerce.model.StatusPedido;
import org.jpaexp.ecommerce.service.NotaFiscalService;

public class GerarNotaFiscalListener {

    @PrePersist
    @PreUpdate
    public void gerar(Pedido pedido){
        if(this.podeGerarNotaFiscal(pedido) ){
             new NotaFiscalService().gerar(pedido);
        }
    }

    private boolean podeGerarNotaFiscal(Pedido pedido) {
        return pedidoPago(pedido) && naoTemNotaFiscal(pedido);
    }

    private static boolean pedidoPago(Pedido pedido) {
        return StatusPedido.PAGO.equals(pedido.getStatus());
    }

    private static boolean naoTemNotaFiscal(Pedido pedido) {
        return pedido.getNotaFiscal() == null;
    }
}
