package dominio.beneficios;

import dominio.Item;
import dominio.Servicio;

public class ProductoGratis extends Beneficio {

    private Item producto;
    
    boolean aplicado;

    public ProductoGratis(Item i){
        this.producto = i;
    }

    @Override
    public String descripcion() {
        return this.producto.getNombre() + " invitación!";
    }

    @Override
    public double calcular(Servicio s) {
        int total = s.obtenerTotalIncidencias(this.producto);
        
        if(total > 0){
            this.aplicado = true;
            return this.producto.getPrecio() * total;
        }
        
        return total;
    }

    @Override
    public boolean fuiAplicado() {
        return aplicado;
    }

}
