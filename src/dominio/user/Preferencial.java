package dominio.user;

import dominio.beneficio.Consumo;
import dominio.beneficio.Regalo;


public class Preferencial implements TipoCliente {

    @Override
    public Consumo getConsumo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Regalo getRegalo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
