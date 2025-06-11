package dominio;

import dominio.estadoPedido.Estado;
import dominio.user.Gestor;
import java.util.Date;
import java.util.Objects;

public class Pedido {

	private Item item;

	private String mensaje;

	private Estado estado;

	private String id;

	private Gestor gestor;

	private Date fecha;

	private Unidad unidad;


        public Pedido(Item i, Unidad u){
            this.item = i;
            this.unidad = u;
        }
        
        
	public String getUnidad() {
		return null;
	}

	public String getGestor() {
		return null;
	}

	public float getPrecio() {
		return 0;
	}

        
        public Pedido(Item i){
        
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.item, other.item);
    }
        
        
}
