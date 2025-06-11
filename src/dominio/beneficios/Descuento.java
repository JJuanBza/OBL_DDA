package dominio.beneficios;

import dominio.Servicio;

public class Descuento implements Beneficio{

    float montoASuperar;
    float porcentajeDescuento;
    
    public Descuento(float m, float p){
        this.montoASuperar = m;
        this.porcentajeDescuento = p;
    }

    @Override
    public String descripcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float calcular(Servicio s) {
        if(s.getMontoTotal() > this.montoASuperar) return s.getMontoTotal() * this.porcentajeDescuento; //para %5 pD = 0,05
        return 0;
    }

}
