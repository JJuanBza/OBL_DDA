package dominio.beneficio.Consumo;

import dominio.Servicio;
import dominio.beneficio.Consumo.Consumo;

public class Descuento extends Consumo{

    float montoASuperar;
    float porcentajeDescuento;
    
    public Descuento(float m, float p){
        this.montoASuperar = m;
        this.porcentajeDescuento = p;
    }

    @Override
    public void calcularConsumo(Servicio s) {

    }

}
