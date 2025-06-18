package dominio;

import excepciones.PedidoClienteException;
import java.util.ArrayList;

public class Item {
    
    private String nombre;
    private float precio;
    private ArrayList<Ingrediente> ingredientes;
    private boolean disponible;
    
    private Unidad unidadProcesadora;
    private Categoria categoria;


    public Item(String nombre, Unidad u, Categoria c, ArrayList<Ingrediente> lista, float precio){
        this.nombre = nombre;
        this.categoria = c;
        this.unidadProcesadora = u;
        this.ingredientes = lista;
        this.precio = precio;
    }

    public Item(String nombre, Unidad u, Categoria c, float precio){
        this.nombre = nombre;
        this.categoria = c;
        this.unidadProcesadora = u;
        this.precio = precio;
        this.ingredientes = new ArrayList();
    }

    public void agregarIngrediente(Ingrediente i){
        this.ingredientes.add(i);
    }

    public Unidad getUnidad() {
        return this.unidadProcesadora;
    }


    public float getPrecio() {
        return this.precio;
    }

    /**
     * foreach(Ingrediente i in this.ingrediente){
     * try{
     * i.validarDisponibilidad();
     * }catch(){
     * throw
     * }
     * }
     */
    public void validarDisponibilidad() throws PedidoClienteException {        
        for(Ingrediente ingrediente : this.ingredientes){
            if(!ingrediente.puedoHacerme()) throw new PedidoClienteException("Nos hemos quedado sin stock de " + this.nombre + " y no pudimos avisarte antes! \n");
        }
    }
    
    public void descontarStock(){
        for(Ingrediente ing : this.ingredientes){
            ing.descontarStock();
        }
    }
    
    public void reintegrarStock(){
        for(Ingrediente ing : this.ingredientes){
            ing.reintegrarStock();
        }
    }

    @Override
    public String toString() {
        return nombre + " - " + precio;
    }

    boolean tengoStock() {
        
        for(Ingrediente i : this.ingredientes){
            if(!i.puedoHacerme()) return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public String getNombre() {
        return this.nombre;
    }


    
}
