package dominio.beneficios;

import dominio.Item;
import dominio.Servicio;

public class ProductoGratis implements Beneficio {

    private Item producto;

    public ProductoGratis(Item i){
        this.producto = i;
    }

    @Override
    public String descripcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float calcular(Servicio s) {
        return this.producto.getPrecio() * s.obtenerTotalIncidencias(this.producto);
    }

}
