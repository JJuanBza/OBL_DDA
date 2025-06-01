package dominio.beneficio.Consumo;

import dominio.Servicio;
import dominio.beneficio.Consumo.Consumo;

public class Gratis extends Consumo {

    private float valorGratis;
    
    public Gratis(float p){
        valorGratis = p;
    }
    

    @Override
    public void calcularConsumo(Servicio s) {
        //montoTotal -= valorGratis;
    }

}
