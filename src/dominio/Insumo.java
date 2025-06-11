package dominio;

public class Insumo {

	private String nombre;

	private int stockMinimo;

	private int stockActual;

        
        public Insumo(String nombre, int min, int actual){
            this.nombre = nombre;
            this.stockMinimo = min;
            this.stockActual = actual;
        }
        
	/**
	 * this.stockActual =- cant;
	 * if(this.stockActual >= cant){
	 * this.stockActual =- cant;	
	 * }else{
	 * throw new Exception();
	 * }
	 */
	public void validarStock(int cant) {

	}

}
