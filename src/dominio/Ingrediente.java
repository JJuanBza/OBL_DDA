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
    public void validarDisponibilidad() {
        if(this.puedoHacerme()) this.descontarStock();
    }

    public boolean puedoHacerme(){
        return this.insumo.tengoStock(this.cantidad);
    }

    public boolean tengoStock(){
        return this.insumo.agotado();
    }

    void descontarStock() {
        this.insumo.descontarStock(this.cantidad);
    }
        
    void reintegrarStock() {
        this.insumo.reintegrarStock(this.cantidad);
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "insumo=" + insumo + '}';
    }

    

}
