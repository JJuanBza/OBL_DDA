package servicio;

import dominio.user.Cliente;
import dominio.user.Gestor;
import dominio.Pedido;
import java.util.Date;

public class Fachada {

	private static Fachada instancia = new Fachada();

	private ServicioUsuario servicioUsuario;

	private ServicioGestor servicioGestor;

	private ServicioDispositivo servicioDispositivo;

	

        public static Fachada getInstancia() {
            return instancia;
        }

	public int getMenu() {
		return 0;
	}

	public Cliente loginCliente(int numero, String password, int idDispositivo) {
		return null;
	}

	public Gestor loginGestor(String usuario, String password) {
		return null;
	}

	public void agregarPedido(Pedido p, int idDispositivo) {

	}

	public void eliminarPedido(Pedido p, int idDispositivo) {

	}

	public void confirmarServicio(Date fecha) {

	}

	public void finalizarServicio() {

	}

}
