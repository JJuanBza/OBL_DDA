package dominio.user;

import dominio.Unidad;
import dominio.Pedido;
import java.util.ArrayList;

public class Gestor extends Usuario{

    private Unidad unidad;

    private ArrayList<Pedido> pedidosAceptados;

    private ArrayList<Pedido> pedido;

    
    public Gestor(String usuario, String contra){
        super(usuario, contra);
    }
    
    
    public Gestor(String usuario, String contra, String nombrecompleto, Unidad u){
        super(usuario, contra, nombrecompleto);
        this.unidad = u;
    }
    
    public void setUnidad(Unidad u){
        this.unidad = u;
    }

    public String getNombre(){
        return this.getNombreCompleto();
    }
    
    public String getNombreUnidad(){
        return this.unidad.getUnidad();
    }
}
