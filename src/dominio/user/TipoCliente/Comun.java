package dominio.user.TipoCliente;

import dominio.Item;
import dominio.beneficio.Consumo.Consumo;
import dominio.beneficio.Regalo.Regalo;
import dominio.beneficio.Consumo.SinDescuento;
import dominio.beneficio.Regalo.SinRegalo;

public class Comun implements TipoCliente {

    @Override
    public Consumo getConsumo(float montoASuperar, float porcentajeDescuento, float montoAFavor) {
        return new SinDescuento();
    }

    @Override
    public Regalo getRegalo(Item i) {
        return new SinRegalo();
    }

}
