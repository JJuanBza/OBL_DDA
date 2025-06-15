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

    boolean tengoStock(double cantidad) {
        return cantidad <= this.stockActual;
    }
    
    boolean agotado(){
        return this.stockMinimo < this.stockActual;
    }

    void descontarStock(double cantidad) {
        this.stockActual -= cantidad;
    }

    @Override
    public String toString() {
        return "Insumo{" + "nombre=" + nombre + ", stockMinimo=" + stockMinimo + ", stockActual=" + stockActual + '}';
    }

}
