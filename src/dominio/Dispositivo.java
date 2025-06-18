package dominio;

import controlador.ClienteControlador;
import dominio.observer.Observable;
import dominio.observer.Observador;
import dominio.user.Cliente;
import excepciones.IdentificacionException;
import excepciones.PedidoClienteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Dispositivo implements Observador{

    private static int contador = 0;
    private final int id;

    private Servicio servicio;
    private Cliente cliente;

    public Dispositivo(){
        this.id = contador++;
        this.cliente = null;
        this.servicio = new Servicio();
    }

    public void setCliente(Cliente c){ 
        this.cliente = c;
        this.servicio.setCliente(c);
    }
    public void desvincular() {
        this.cliente.LogOUT();
        this.setCliente(null);
        this.setServicio(new Servicio());
        
    }
    
    
    public void setServicio(Servicio s){ this.servicio = s;}

    public Cliente getCliente(){ return this.cliente;}
    public Servicio getServicio(){ return this.servicio;}
    
    public void tengoCliente() throws IdentificacionException{
        if(this.cliente != null) throw new IdentificacionException("Debe primero finalizar el servicio actual");
    }

    public void confirmar(LocalDateTime fecha) throws PedidoClienteException{
        this.servicio.confirmar(fecha);
    }

    public void agregarPedido(Item i, String comentario) throws PedidoClienteException {
        this.servicio.agregarPedido(i, comentario);
    }

    public void eliminarPedido(int indicePedido) throws Exception{
        this.servicio.eliminarPedido(indicePedido);
    }
    
    public ArrayList<Pedido> getPedidos(){
        return this.servicio.getPedidos();
    }
    
    public float getCostos(){ return this.servicio.getMontoTotal();}
    

    
    public void validarPedidos() throws PedidoClienteException{
        this.servicio.existenPedidos();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public void asociarObservadorController(ClienteControlador controlador) {
        this.servicio.agregarObservador(controlador);
    }

    public void finalizar() {
        this.servicio.pagarServicio();
    }

    public void pedidosConfirmados() throws PedidoClienteException {
        this.servicio.pedidosConfirmados();
    }

    public String pedidosNoEntregados() {
        return this.servicio.pedidosNoEntregados();
    }

    public String beneficioAplicado() {
        return this.servicio.obtenerBeneficioAplicado();
    }

    public float getFinal() {
        return this.servicio.getFinal();
    }


    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dispositivo other = (Dispositivo) obj;
        return Objects.equals(this.servicio, other.servicio);
    }

    public boolean hayPedidos() {
        return this.servicio.hayPedidos();
    }
}
