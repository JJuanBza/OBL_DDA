package dominio.estadoPedido;

import dominio.Pedido;
import dominio.Pedido.Estados;
import excepciones.PedidoClienteException;

public class Confirmado extends Estado {
    
    public Confirmado(Pedido p) {
        super(p, Estados.CONFIRMADO);
    }

    @Override
    public void confirmar() throws PedidoClienteException{
        throw new PedidoClienteException("El pedido ya esta Confirmado");
    }

    @Override
    public void procesar() throws PedidoClienteException{
        this.getPedido().cambiarEstado(new EnProceso(this.getPedido()));
    }

    @Override
    public void finalizar() throws PedidoClienteException{
        throw new PedidoClienteException("Debe finalizar el pedido");
    }

    @Override
    public void entregar() throws PedidoClienteException{
        throw new UnsupportedOperationException("Debe finalizar el pedido primero!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String quienSoy() {
        return "Confirmado";
    }
    
}
