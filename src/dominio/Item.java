package dominio;

import java.util.ArrayList;

public class Item {

	private String nombre;

	private float precio;

	private ArrayList<Ingrediente> ingredientes;

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
        
	public String getUnidad() {
		return null;
	}

	public String getGestor() {
		return null;
	}

	public float getPrecio() {
		return 0;
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
	public void validarDisponibilidad() {

	}

    @Override
    public String toString() {
        return nombre;
    }

}
