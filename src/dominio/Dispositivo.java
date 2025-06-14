package dominio;

import dominio.user.Cliente;
import java.util.Date;

public class Dispositivo {

    private static int contador = 0;
    private final int id;

    private Servicio servicio;
    private Cliente cliente;

    public Dispositivo(){
        this.id = contador++;
        this.cliente = null;
        this.servicio = null;
    }

    public void setCliente(Cliente c){ this.cliente = c;}
    public void setServicio(Servicio s){ this.servicio = s;}

    public Cliente getCliente(){ return this.cliente;}
    public Servicio getServicio(){ return this.servicio;}

    public void confirmar(Date fecha) {

    }

    public void agregarPedido(Item i, String comentario) {
        if(this.servicio == null){
            this.servicio = new Servicio(this.cliente);
        }

        this.servicio.agregarPedido(new Pedido(i, comentario));
    }

    public void eliminarPedido(Pedido p) {

    }

    public boolean validarPedidos() {
        return this.servicio.existenPedidos();
    }

}
