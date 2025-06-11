package dominio;

import java.util.ArrayList;

public class Categoria {

	private String nombre;

	private ArrayList<Item> items;

        public Categoria(String nombre){
            this.nombre = nombre;
            this.items = new ArrayList();
        }
        
        public void agregarItem(Item i){
            this.items.add(i);
        }
}
