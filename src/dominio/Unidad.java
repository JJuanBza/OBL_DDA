package dominio;

import dominio.observer.Observable;
import dominio.observer.Observador;
import dominio.user.Gestor;
import java.util.ArrayList;

public class Unidad extends Observable implements Observador{

    private String nombre;
    private ArrayList<Gestor> gestores;
    private ArrayList<Pedido> pedidos;


    public Unidad(String nom){
        this.nombre = nom;
        this.gestores = new ArrayList();
        this.pedidos = new ArrayList();
    }


    public String getUnidad() {
        return this.nombre;
    }

    public void agregarPedido(Pedido p) {
        this.pedidos.add(p);
        p.agregarObservador(this);
        this.actualizarPedidos();
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Pedido> pedidosDisponibles() {
        return this.pedidos;
    }

    public void pedidoTomado(Pedido seleccionado) {
        this.pedidos.remove(seleccionado);
        this.actualizarPedidos();
    }
    
    public void actualizarPedidos(){
        avisar(EstadosSistema.ACTUALIZAR);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        this.actualizarPedidos();
    }

}
