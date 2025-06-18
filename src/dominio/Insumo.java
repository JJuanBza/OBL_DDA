package dominio;


public class Insumo {

    private String nombre;

    private double stockMinimo;

    private double stockActual;


    public Insumo(String nombre, double min, double actual){
        this.nombre = nombre;
        this.stockMinimo = min;
        this.stockActual = actual;
    }

    boolean tengoStock(double cantidad) {
        return cantidad <= this.stockActual;
    }
    
    boolean agotado(){
        return this.stockMinimo < this.stockActual;
    }

    void descontarStock(double cantidad) {
        this.stockActual -= cantidad;
    }
    
    void reintegrarStock(double cantidad) {
        this.stockActual += cantidad;
    }

    @Override
    public String toString() {
        return "Insumo{" + "nombre=" + nombre + ", stockMinimo=" + stockMinimo + ", stockActual=" + stockActual + '}';
    }

}
