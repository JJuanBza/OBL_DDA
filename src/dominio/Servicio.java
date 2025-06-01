package dominio;

import dominio.user.Cliente;
import dominio.beneficio.Consumo.Consumo;
import dominio.beneficio.Regalo.Regalo;
import java.util.ArrayList;
import java.util.Date;

public class Servicio {

	private Cliente cliente;

	private ArrayList<Pedido> pedidos;

	private float montoTotal;

	private float montoBeneficio;

	private Consumo consumo;

	private Regalo regalo;

	private Unidad unidad;

	/**
	 * foreach(Pedido p in this.pedidos){
	 * try{
	 * p.validarDisponibilidad();
	 * p.agregarPedido();
	 * }catch(){
	 * 
	 * }
	 * }
	 */
	public void confirmar(Date fecha) {

	}

	/**
	 * try{
	 * p.validarEstado();
	 * p.eliminar();
	 * this.pedidos.eliminar(p);
	 * }catch(){
	 * 
	 * }
	 */
	public void eliminarPedido(Pedido p) {

	}

	public void agregarPedido(Pedido p) {

	}


}
