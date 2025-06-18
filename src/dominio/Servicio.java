package dominio;

import dominio.observer.Observable;
import dominio.user.Cliente;
import excepciones.PedidoClienteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Servicio extends Observable{

    private Cliente cliente;
    private ArrayList<Pedido> pedidos;
    private float montoTotal;
    private float montoFinal;
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
    
    public float getMontoFinal(){
        return this.montoFinal;
    }

    public float getMontoBeneficio() {
        return montoBeneficio;
    }


    public void confirmar(LocalDateTime fecha) throws PedidoClienteException{
        this.validarConfirmarStockPedidos(fecha, this.existenPedidos());
        avisar(EstadosSistema.CONFIRMADO);
    }

    public void eliminarPedido(int indicePedido) throws PedidoClienteException{
        Pedido p = this.pedidos.get(indicePedido);
        
        this.eliminarPedido(p);
    }
    
    private void eliminarPedido(Pedido p) throws PedidoClienteException{
        p.validarEstado();
        this.pedidos.remove(p);
        this.montoTotal -= p.getPrecio();
        
        avisar(EstadosSistema.BAJA_PEDIDO);
    }
    
    private void eliminarPedidosAlfinal(ArrayList<Pedido> pedidos){
        for(Pedido p : pedidos){
            this.pedidos.remove(p);
            this.montoTotal -= p.getPrecio();
        }
        
        avisar(EstadosSistema.BAJA_PEDIDO);
    }
    

    public void agregarPedido(Item item, String comentario) throws PedidoClienteException {
        Pedido p = new Pedido(item, comentario);
        
        p.validarDisponibilidad();
        this.pedidos.add(p);
        this.montoTotal += p.getPrecio();
        
        avisar(EstadosSistema.ALTA_PEDIDO);
    }

    public void pagarServicio(){
        //caclular beneficio
        float beneficio = cliente.getTipoCliente().calcularMontoConBeneficios(this);
        
        this.montoBeneficio = beneficio;
        this.montoFinal = this.montoTotal;
        this.montoFinal -= this.montoBeneficio;
        
        avisar(EstadosSistema.FINALIZADO);
    }

    public int obtenerTotalIncidencias(Item i) {
        int total = 0;
        for(Pedido p : this.getPedidos()){
            if(p.tengoItem(i)) total++;
        }

        return total;
    }

    
    public ArrayList<Pedido> existenPedidos() throws PedidoClienteException{
        
        ArrayList<Pedido> nuevos = new ArrayList();
        
        for(Pedido p : this.getPedidos()){
            boolean b = p.estoyConfirmado();
            if(!b) nuevos.add(p);
        }
        
        if(nuevos.isEmpty()) throw new PedidoClienteException("No hay pedidos nuevos");
        
        return nuevos;
    }

    
   
    private void validarConfirmarStockPedidos(LocalDateTime fecha, ArrayList<Pedido> pedidosNuevos) throws PedidoClienteException{
        ArrayList<Pedido> pedidosInvalidos = new ArrayList<>();
        String error = new String();

        for (Pedido pedido : pedidosNuevos) {
            try {
                pedido.validarDisponibilidad();
                pedido.confirmar(fecha);
            } catch (PedidoClienteException ex) {
                error = error + ex.getMessage();
                pedidosInvalidos.add(pedido);
            }
        }

        this.eliminarPedidosAlfinal(pedidosInvalidos);
        
        if (!error.isEmpty()) {
            throw new PedidoClienteException(error);
        }
    }

    void pedidosConfirmados() throws PedidoClienteException{
        for(Pedido p : this.getPedidos()){
            if(!p.estoyConfirmado()) throw new PedidoClienteException("Tiene pedidos sin Confirmar!");
        }
    }

    String pedidosNoEntregados() {
        int cont = 0;
        for(Pedido p : this.getPedidos()){
            if(!p.estoyEntregado()) cont++;
        }
        
        return "¡Tienes " + cont + " pedidos en proceso, recuerda ir a retirarlos!";
    }

    String obtenerBeneficioAplicado() {
        return this.cliente.getTipoCliente().getNombreBeneficios();
    }

    float getFinal() {
        return this.montoFinal;
    }

    boolean hayPedidos(){
        return !this.pedidos.isEmpty();
    }


}
