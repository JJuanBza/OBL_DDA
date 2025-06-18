package dominio;

import dominio.estadoPedido.Estado;
import dominio.estadoPedido.NoConfirmado;
import dominio.observer.Observable;
import dominio.user.Cliente;
import dominio.user.Gestor;
import excepciones.PedidoClienteException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pedido extends Observable{

    private static int cont = 0;
    private final int id;
    
    private Item item;
    private String comentario;
    private Estado estado = new NoConfirmado(this);
    private Unidad unidad;
    private Gestor gestor;
    private Cliente cliente;
    private double precio;
    private LocalDateTime fecha;


    public enum Estados{NO_CONFIRMADO,CONFIRMADO,EN_PROCESO, FINALIZADO, ENTREGADO};
    
    public Pedido(Item i, String comentario, Cliente cli){
        this.id = cont++;
        this.item = i;
        this.comentario = comentario;
        this.unidad = i.getUnidad();
        this.cliente = cli;
        this.precio = i.getPrecio();
    }
    
    


    public Item getItem(){ return this.item;}
    
    public String getComentario(){ return this.comentario;}
    
    public Estado getEstado(){ return this.estado;}
    
    public Unidad getUnidad() { return this.unidad;}

    public Gestor getGestor() { return this.gestor;}

    public double getPrecio() { return this.precio;}

    public String miEstado(){ return this.estado.quienSoy();}

    public String nombreItem() {
        return this.item.getNombre();
    }

    public String getCliente() {
        return this.cliente.getNombreCompleto();
    }

    public LocalDateTime getFechaHora() {
        return this.fecha;
    }
    
    public void setGestor(Gestor gestor) throws PedidoClienteException {
        this.gestor = gestor;
        this.estado.procesar();
        avisar(EstadosSistema.ACTUALIZAR);
    }
    
    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    boolean estoyConfirmado() {
        return estado.mismoEstado(Estados.CONFIRMADO);
    }

    public boolean estoyEntregado() {
        return estado.mismoEstado(Estados.ENTREGADO);
    }
    
    boolean soyNoConfirmado() {
        return estado.mismoEstado(Estados.NO_CONFIRMADO);
    }
    
    
    public void confirmar(LocalDateTime fecha) throws PedidoClienteException {
        //Descuenta el stock de los insumos de todos los ítems de los pedidos
        this.item.descontarStock();
        
        //actualiza los datos del servicio
        this.fecha = fecha;
        this.estado.confirmar();
        
        //envía los pedidos a la unidad procesadora correspondiente a cada ítem
        this.agregarPedidoUnidad();
        
    }
    
    public void tomarPedido() throws PedidoClienteException {
        this.estado.procesar();
        this.unidad.actualizarPedidos();
    }
    
    public void finalizarPedido() throws PedidoClienteException {
        this.estado.finalizar();
        avisar(EstadosSistema.ACTUALIZAR);
    }
    
    public void entregarPedido() throws PedidoClienteException {
        this.estado.entregar();
        avisar(EstadosSistema.ACTUALIZAR);
    }

    /**
     * item.validarDisponibilidad();
     * this.fecha = fecha;
     */
    public void validarDisponibilidad() throws PedidoClienteException{
        this.item.validarDisponibilidad();
    }

    public void descontarStock(LocalDateTime fecha){
        this.fecha = fecha;
    }

    public void validarEstado() throws PedidoClienteException{
        if(!estado.mismoEstado(Estados.NO_CONFIRMADO) && !estado.mismoEstado(Estados.CONFIRMADO)) throw new PedidoClienteException("Un poco tarde… Ya estamos elaborando este pedido!");
        
        if(this.estoyConfirmado()){ this.item.reintegrarStock();}
    }

    /**
     * unidad.agregarPedido(this);
     */
    public void agregarPedidoUnidad() {
        unidad.agregarPedido(this);
    }
    
    public void eliminarPedidoUnidad(){
        unidad.removerPedido(this);
    }
    
    boolean tengoItem(Item i) {
        return this.item.equals(i);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }
        
}
