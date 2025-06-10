package dominio;

import dominio.user.Cliente;
import java.util.Date;

public class Dispositivo {

	private static int contador = 0;
        private final int id;

	private Servicio servicio;

	private Cliente cliente;

        public Dispositivo(){
            this.id = contador++;
            this.cliente = null;
            this.servicio = null;
        }

	public void confirmar(Date fecha) {

	}

	public void agregarPedido(Pedido p) {

	}

	public void eliminarPedido(Pedido p) {

	}

}
