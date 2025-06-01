package dominio.user.TipoCliente;

import dominio.Item;
import dominio.beneficio.Consumo.Consumo;
import dominio.beneficio.Consumo.SinDescuento;
import dominio.beneficio.Regalo.ProductoGratis;
import dominio.beneficio.Regalo.Regalo;

public class Frecuente implements TipoCliente {

    @Override
    public Consumo getConsumo(float montoASuperar, float porcentajeDescuento, float montoAFavor) {
        return new SinDescuento();
    }

    @Override
    public Regalo getRegalo(Item i) {
        return new ProductoGratis(i); 
    }

}
