package dominio.user.TipoCliente;

import dominio.Item;
import dominio.beneficio.Consumo.Consumo;
import dominio.beneficio.Consumo.Gratis;
import dominio.beneficio.Regalo.Regalo;
import dominio.beneficio.Regalo.SinRegalo;

public class DeLaCasa implements TipoCliente {

    @Override
    public Consumo getConsumo(float montoASuperar, float porcentajeDescuento, float montoAFavor) {
        return new Gratis(montoAFavor);
    }

    @Override
    public Regalo getRegalo(Item i) {
        return new SinRegalo();
    }

}
