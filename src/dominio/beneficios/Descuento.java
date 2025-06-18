package dominio.beneficios;

import dominio.Servicio;

public class Descuento extends Beneficio{

    float montoASuperar;
    double porcentajeDescuento;
    
    boolean aplicado;
    
    public Descuento(float m, double p){
        this.montoASuperar = m;
        this.porcentajeDescuento = p;
    }
    
    public boolean fuiAplicado(){ return this.aplicado;}

    @Override
    public String descripcion() {
        return "Obtuvo un %" + Math.round(porcentajeDescuento * 100) + " por superar los $" + montoASuperar;
    }

    @Override
    public double calcular(Servicio s) {
        if(s.getMontoTotal() >= this.montoASuperar){
            this.aplicado = true;
            return s.getMontoTotal() * this.porcentajeDescuento; //para %5 pD = 0,05
        }
            
        return 0;
    }

}
