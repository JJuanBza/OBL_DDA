package dominio;

import dominio.observer.Observable;
import dominio.user.Cliente;
import excepciones.PedidoClienteException;
import excepciones.ValidacionMultipleException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Servicio extends Observable{

    private Cliente cliente;
    private ArrayList<Pedido> pedidos;
    private float montoTotal;
    private float montoBeneficio;
    
    
    public Servicio(){
        this.cliente = null;
        this.pedidos = new ArrayList();
        this.montoTotal = 0;
        this.montoBeneficio = 0;
    }
    
    public void setCliente(Cliente c){
        this.cliente = c;
    }

    public void setMontoBeneficio(float montoBeneficio) {
        this.montoBeneficio = montoBeneficio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public float getMontoBeneficio() {
        return montoBeneficio;
    }


    /**
     * foreach(Pedido p in this.pedidos){
     * try{
     * p.validarDisponibilidad();
     * p.agregarPedido();
     * }catch(){
     * 
     * }
     * }
     */
    public void confirmar(LocalDateTime fecha) throws PedidoClienteException{
        /*
        [/]Si no hay pedidos para procesar muestra mensaje “No hay pedidos nuevos”.
        [/]Si no hay stock suficiente en alguno(s) de los pedido(s): 
            Para cada pedido sin stock muestra: 
        “Nos hemos quedado sin stock de “ + nombre del ítem + “ y no pudimos avisarte antes!” 
        y quita los pedidos del servicio.
        */
        this.existenPedidos();
        this.validarStockPedidos();
        
        /*
        Procesa los pedidos del servicio que estén sin procesar de la siguiente forma: 
        []Descuenta el stock de los insumos de todos los ítems de los pedidos, 
        []envía los pedidos a la unidad procesadora correspondiente a cada ítem
        []actualiza los datos del servicio
        */
        this.confirmarPedidos(fecha);
        
        
    }

    /**
     * try{
     * p.validarEstado();
     * p.eliminar();
     * this.pedidos.eliminar(p);
     * }catch(){
     * 
     * }
     */
    public void eliminarPedido(int indicePedido) throws Exception{
        Pedido p = this.pedidos.get(indicePedido);
        p.validarEstado();
        this.pedidos.remove(p);
        this.montoTotal -= p.getPrecio();
        
        avisar(EstadosSistema.BAJA_PEDIDO);
    }

    public void agregarPedido(Item item, String comentario) {
        Pedido p = new Pedido(item, comentario);
        
        this.pedidos.add(p);
        this.montoTotal += p.getPrecio();
        
        avisar(EstadosSistema.ALTA_PEDIDO);
    }

    public void pagarServicio(){
        //caclular beneficio
        //float beneficio = cliente.calcularMontoBeneficio();

        //this.montoBeneficio = beneficio;
        this.montoTotal -= this.montoBeneficio;
    }

    public int obtenerTotalIncidencias(Item i) {
        int total = 0;
        for(Pedido p : this.getPedidos()){
            if(p.equals(new Pedido(i))) total++;
        }

        return total;
    }

    
    public void existenPedidos() throws PedidoClienteException{
        if(this.todosConfirmados()) throw new PedidoClienteException("No hay pedidos nuevos");
    }
    
    private boolean todosConfirmados(){
        for(Pedido p : this.getPedidos()){
            if(!p.estoyConfirmado()) return false;
        }
        
        return true;
    }
    
   
    private void validarStockPedidos() throws PedidoClienteException{
        
        StringBuilder error = new StringBuilder();
        
        for (Pedido pedido : this.getPedidos()) {
            try{
                pedido.validarDisponibilidad();
            }catch(PedidoClienteException ex){
                error.append(ex.getMessage());
                this.pedidos.remove(pedido);
            }
        }
        
        if(error.isEmpty()) throw new PedidoClienteException(error.toString());
    }

    private void confirmarPedidos(LocalDateTime fecha) throws PedidoClienteException {
        for(Pedido p : this.getPedidos()){
            p.confirmar(fecha);
        }
    }

}
