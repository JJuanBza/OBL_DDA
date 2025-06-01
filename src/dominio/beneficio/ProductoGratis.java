package dominio.beneficio;

import dominio.Item;

public class ProductoGratis implements Regalo {

    private Item producto;

    public ProductoGratis(Item i){
        this.producto = i;
    }
    
    @Override
    public void calcularRegalo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
