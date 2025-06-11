package servicio;

import dominio.user.Cliente;
import dominio.user.Gestor;
import dominio.Pedido;
import dominio.Unidad;
import java.util.Date;

public class Fachada {

	private static Fachada instancia = new Fachada();

	private ServicioUsuario servicioUsuario = new ServicioUsuario();

	private ServicioGestor servicioGestor;

	private ServicioDispositivo servicioDispositivo;

	

        public static Fachada getInstancia() {
            return instancia;
        }

	public int getMenu() {
		return 0;
	}

	public Cliente loginCliente(String numero, String password, int idDispositivo) {
            return this.servicioUsuario.loginCliente(numero, password);
	}

	public Gestor loginGestor(String usuario, String password) {
            return this.servicioUsuario.loginGestor(usuario, password);
	}

	public void agregarPedido(Pedido p, int idDispositivo) {

	}

	public void eliminarPedido(Pedido p, int idDispositivo) {

	}

	public void confirmarServicio(Date fecha) {

	}

	public void finalizarServicio() {

	}

        public void agregarCliente(String user, String pass, String nomCompleto){
            this.servicioUsuario.agregarCliente(user, pass, nomCompleto);
        }
        
        public void agregarGestor(String user, String pass, String nomCompleto, Unidad u){
            this.servicioUsuario.agregarGestor(user, pass, nomCompleto, u);
        }
}
