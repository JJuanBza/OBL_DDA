package dominio.estadoPedido;

import dominio.Pedido;
import dominio.Pedido.Estados;
import excepciones.PedidoClienteException;

public class Entregado extends Estado {

    public Entregado(Pedido p) {
        super(p, Estados.ENTEGADO);
    }

    @Override
    public void confirmar() throws PedidoClienteException {
        throw new PedidoClienteException("Not supported yet.");
    }

    @Override
    public void procesar() throws PedidoClienteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void finalizar() throws PedidoClienteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void entregar() throws PedidoClienteException {
        throw new PedidoClienteException("El pedido ya está entregado");
    }

   

}
