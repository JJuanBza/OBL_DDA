package dominio.user;

import dominio.beneficio.Regalo;
import dominio.beneficio.Consumo;

public interface TipoCliente {

	public Consumo getConsumo();
        public Regalo getRegalo();
}
