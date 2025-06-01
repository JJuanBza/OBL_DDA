package dominio;

import dominio.estadoPedido.Estado;
import dominio.user.Gestor;
import java.util.Date;

public class Pedido {

	private Item item;

	private String mensaje;

	private Estado estado;

	private String id;

	private Gestor gestor;

	private Date fecha;

	private Unidad unidad;


	public String getUnidad() {
		return null;
	}

	public String getGestor() {
		return null;
	}

	public float getPrecio() {
		return 0;
	}

	/**
	 * item.validarDisponibilidad();
	 * this.fecha = fecha;
	 */
	public void validarDisponibilidad(Date fecha) {
            
	}

	/**
	 * unidad.eliminarPedido(this);
	 */
	public void eliminar(Pedido p) {

	}

	/**
	 * if(estado != NO CONFIRMADO || estado != CONFIRMADO) throw new Exception();
	 */
	public void validarEstado() {

	}

	/**
	 * unidad.agregarPedido(this);
	 */
	public void agregarPedido() {
            unidad.agregarPedido(this);
	}

}
