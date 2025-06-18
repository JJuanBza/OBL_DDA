package dominio.estadoPedido;

import dominio.Pedido;
import dominio.Pedido.Estados;
import excepciones.PedidoClienteException;

public abstract class Estado {

    private Pedido pedido;
    private Estados estado;
    

    public Estado(Pedido p, Estados e){ 
        this.pedido = p;
        this.estado = e;
    }
    public Pedido getPedido(){ return this.pedido;}

    //public abstract void siguienteEstado();
    public abstract void confirmar() throws PedidoClienteException;
    public abstract void procesar() throws PedidoClienteException;
    public abstract void finalizar() throws PedidoClienteException;
    public abstract void entregar() throws PedidoClienteException;
    public abstract String quienSoy();

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public boolean mismoEstado(Estados estados) {
        return this.estado.equals(estados);
    }
   
}
