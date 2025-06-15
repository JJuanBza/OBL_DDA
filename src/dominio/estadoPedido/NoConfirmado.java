package dominio.estadoPedido;

import dominio.Pedido;
import dominio.Pedido.Estados;
import excepciones.PedidoClienteException;

public class NoConfirmado extends Estado {

    public NoConfirmado(Pedido p) {
        super(p, Estados.NO_CONFIRMADO);
    }

    @Override
    public void confirmar() throws PedidoClienteException{
        this.getPedido().cambiarEstado(new Confirmado(getPedido()));
    }

    @Override
    public void procesar() throws PedidoClienteException{
        throw new PedidoClienteException("");
    }

    @Override
    public void finalizar() throws PedidoClienteException{
        throw new UnsupportedOperationException("Tienes pedidos sin confirmar!");
    }

    @Override
    public void entregar() throws PedidoClienteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
