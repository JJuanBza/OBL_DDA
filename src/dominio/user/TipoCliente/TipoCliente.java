package dominio.user.TipoCliente;

import dominio.Item;
import dominio.beneficio.Regalo.Regalo;
import dominio.beneficio.Consumo.Consumo;

public interface TipoCliente {

	Consumo getConsumo(float montoASuperar, float porcentajeDescuento, float montoAFavor);
        Regalo getRegalo(Item i);
}
