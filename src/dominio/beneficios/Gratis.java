package dominio.beneficios;

import dominio.Servicio;

public class Gratis extends Beneficio{

    private double valorGratis;
    
    public Gratis(double p){
        valorGratis = p;
    }

    @Override
    public String descripcion() {
        return "Tiene " + valorGratis + " de consumo gratis por Servicio!";
    }

    @Override
    public double calcular(Servicio s) {
        if(s.getMontoTotal() < this.valorGratis) return s.getMontoTotal();
        
        return this.valorGratis;
    }

    @Override
    public boolean fuiAplicado() {
        return true;
    }

}
