package dominio.user;

import dominio.user.TipoCliente.TipoCliente;
import dominio.beneficio.Regalo.Regalo;
import dominio.beneficio.Consumo.Consumo;
import dominio.Servicio;

public class Cliente extends Usuario{

	private boolean logged;

	private Regalo regalo;

	private Consumo consumo;

	private TipoCliente tipo;

	private TipoUsuario tipoUsuario;

	private Servicio servicio;

	private TipoCliente tipoCliente;

}
