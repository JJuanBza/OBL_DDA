package dominio.estadoPedido;

import dominio.Pedido;

public abstract class Estado {

	private Pedido pedido;
        
        
        public Estado(Pedido p){ this.pedido = p;}
        public Pedido getPedido(){ return this.pedido;}
        

	public abstract void eliminar();
	public abstract void confirmado();
	public abstract void cobrar();

}
