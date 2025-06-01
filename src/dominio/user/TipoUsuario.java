package dominio.user;

import dominio.Dispositivo;
import dominio.Servicio;
import dominio.beneficio.Regalo.Regalo;
import dominio.beneficio.Consumo.Consumo;

public abstract class TipoUsuario {

	private Dispositivo dispositivo;

	private Servicio servicio;

	private Regalo regalo;

	private Consumo consumo;

	public void pagar() {

	}

}
