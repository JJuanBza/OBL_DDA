package dominio.estadoPedido;

import dominio.Pedido;
import dominio.Pedido.Estados;
import excepciones.PedidoClienteException;

public class Finalizado extends Estado {

    public Finalizado(Pedido p) {
        super(p, Estados.FINALIZADO);
    }

    @Override
    public void confirmar() throws PedidoClienteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void procesar() throws PedidoClienteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void finalizar() throws PedidoClienteException {
        throw new PedidoClienteException("El pedido ya está finalizado");
    }

    @Override
    public void entregar() throws PedidoClienteException {
        this.getPedido().cambiarEstado(new Entregado(this.getPedido()));
    }



}
