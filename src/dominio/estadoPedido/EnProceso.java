/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.estadoPedido;

import dominio.Pedido;
import dominio.Pedido.Estados;
import excepciones.PedidoClienteException;

/**
 *
 * @author Emiliano Barcosta
 */
public class EnProceso extends Estado {

    public EnProceso(Pedido p) {
        super(p, Estados.EN_PROCESO);
    }

    @Override
    public void confirmar() throws PedidoClienteException{
        throw new PedidoClienteException("El pedido ya fue confirmado");
    }

    @Override
    public void procesar() throws PedidoClienteException{
        throw new PedidoClienteException("El pedido está en proceso!");
    }

    @Override
    public void finalizar() throws PedidoClienteException{
        this.getPedido().cambiarEstado(new Finalizado(this.getPedido()));
    }

    @Override
    public void entregar() throws PedidoClienteException{
        throw new PedidoClienteException("Debe Finalizar primero");
    }

    
}
