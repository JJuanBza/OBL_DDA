package dominio.beneficio.Regalo;

import dominio.Item;
import dominio.Servicio;

public class ProductoGratis implements Regalo {

    private Item producto;

    public ProductoGratis(Item i){
        this.producto = i;
    }

    @Override
    public void calcularRegalo(Servicio s) {
        
    }

}
