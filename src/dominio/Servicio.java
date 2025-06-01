package dominio;

import dominio.user.Cliente;
import dominio.beneficio.Consumo;
import dominio.beneficio.Regalo;
import java.util.ArrayList;
import java.util.Date;

public class Servicio implements Consumo, Regalo{

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
            for(Pedido p : this.pedidos){
                try{
                    p.validarDisponibilidad(fecha);
                    p.agregarPedido();
                }catch(){
	  
                }
            }
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

        @Override
        public void calcularConsumo() {
            
        }

        @Override
        public void calcularRegalo() {
            
        }

}
