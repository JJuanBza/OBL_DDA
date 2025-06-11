package dominio;

public class Ingrediente {

	private Insumo insumo;

	private double cantidad;

        
        public Ingrediente(Insumo i, double cant){
            this.cantidad = cant;
            this.insumo = i;
        }
        
	/**
	 * try{
	 * insumo.validarStock();
	 * }catch(){
	 * 
	 * }
	 */
	public void validarDisponibilidad(int cant) {

	}

}
