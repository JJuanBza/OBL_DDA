package dominio;

import java.util.ArrayList;

public class Categoria {

    private String nombre;

    private ArrayList<Item> items;

    public Categoria(String nombre){
        this.nombre = nombre;
        this.items = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
    public ArrayList<Item> obtenerItems(){
        ArrayList<Item> itemsDisponibles = new ArrayList();
        
        for(Item i : this.items){
            if(i.tengoStock()) itemsDisponibles.add(i);
        }
        
        return itemsDisponibles;
    }
        
    public void agregarItem(Item i){
        this.items.add(i);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
