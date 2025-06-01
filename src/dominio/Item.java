package dominio;

import java.util.ArrayList;

public class Item {

	private String nombre;

	private float precio;

	private ArrayList<Ingrediente> ingredientes;

	private Unidad unidadProcesadora;

	private Categoria categoria;

	private Item item;

	private Insumo insumo;


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

}
