package dominio.user.TipoCliente;

import dominio.Item;
import dominio.beneficio.Consumo.Consumo;
import dominio.beneficio.Consumo.Descuento;
import dominio.beneficio.Regalo.ProductoGratis;
import dominio.beneficio.Regalo.Regalo;


public class Preferencial implements TipoCliente {

    @Override
    public Consumo getConsumo(float montoASuperar, float porcentajeDescuento, float montoAFavor) {
        return new Descuento(montoASuperar, porcentajeDescuento);
    }

    @Override
    public Regalo getRegalo(Item i) {
        return new ProductoGratis(i);
    }

}
