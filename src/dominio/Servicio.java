package dominio;

import dominio.user.Cliente;
import java.util.ArrayList;
import java.util.Date;

public class Servicio {

	private Cliente cliente;

	private ArrayList<Pedido> pedidos;

	private float montoTotal;

	private float montoBeneficio;

	private Unidad unidad;

    public void setMontoBeneficio(float montoBeneficio) {
        this.montoBeneficio = montoBeneficio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public float getMontoBeneficio() {
        return montoBeneficio;
    }

    public Unidad getUnidad() {
        return unidad;
    }

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
            //agregar pedido
            this.pedidos.add(p);
            
            this.montoTotal += p.getPrecio();
	}

        public void pagarServicio(){
            //caclular beneficio
            float beneficio = cliente.calcularMontoBeneficio();
            
            this.montoBeneficio = beneficio;
            this.montoTotal -= this.montoBeneficio;
        }

        public int obtenerTotalIncidencias(Item i) {
            int total = 0;
            for(Pedido p : this.getPedidos()){
                if(p.equals(new Pedido(i))) total++;
            }
            
            return total;
        }
}
