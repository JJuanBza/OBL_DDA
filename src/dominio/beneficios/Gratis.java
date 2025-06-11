package dominio.beneficios;

import dominio.Servicio;

public class Gratis implements Beneficio{

    private float valorGratis;
    
    public Gratis(float p){
        valorGratis = p;
    }

    @Override
    public String descripcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float calcular(Servicio s) {
        return this.valorGratis;
    }

}
