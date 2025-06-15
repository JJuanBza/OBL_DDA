package servicio;

import dominio.Dispositivo;
import dominio.Categoria;
import dominio.Item;
import dominio.Pedido;
import java.util.ArrayList;
import java.util.Date;

public class ServicioDispositivo {

    private ArrayList<Categoria> categorias;

    private ArrayList<Dispositivo> dispositivos;

    private Dispositivo dispositivo;

    private Categoria categoria;

    
    public ServicioDispositivo(){
        this.categorias = new ArrayList();
        this.dispositivos = new ArrayList();
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    
    public int getMenu() {
            return 0;
    }

    public void confirmarServicio(Date fecha) {

    }

    public void agregarPedido(Pedido p, int idDispositivo) {

    }

    public void eliminarPedido(Pedido p, int idDispositivo) {

    }

    ArrayList<Categoria> getCategorias() {
        return this.categorias;
    }

    void agregarCategoria(Categoria c) {
        this.categorias.add(c);
    }

    ArrayList<Item> obtenerItemsDe(Categoria c) {
        return  c.obtenerItems();
    }


}
