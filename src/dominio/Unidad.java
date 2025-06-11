package dominio;

import dominio.user.Gestor;
import java.util.ArrayList;

public class Unidad {

	private String nombre;

	private ArrayList<Gestor> gestores;

	private ArrayList<Pedido> pedidos;

        
        public Unidad(String nom){
            this.nombre = nom;
            this.gestores = new ArrayList();
            this.pedidos = new ArrayList();
        }
        

	public String getUnidad() {
            return this.nombre;
	}

	public String getGestor() {
		return null;
	}

	public void agregarPedido(Pedido p) {
            this.pedidos.add(p);
	}

	/**
	 * this.pedidos.eliminar(p);
	 */
	public void eliminarPedido(Pedido p) {

	}

}
