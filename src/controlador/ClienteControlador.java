/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Categoria;
import dominio.Dispositivo;
import dominio.EstadosSistema;
import dominio.Item;
import dominio.Pedido;
import dominio.observer.Observable;
import dominio.observer.Observador;
import dominio.user.Cliente;
import excepciones.IdentificacionException;
import excepciones.PedidoClienteException;
import excepciones.UsuarioNULOException;
import excepciones.ValidacionMultipleException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import servicio.Fachada;
import vista.VistaClientes;

/**
 *
 * @author Emiliano Barcosta
 */
public class ClienteControlador implements Observador{
    
    private Cliente cliente;
    private Dispositivo dispositivo;
    
    private VistaClientes vista;
    
    
    public ClienteControlador(VistaClientes vista){
        this.cliente = null;
        this.dispositivo = new Dispositivo();
        this.vista = vista;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.vincularDispositivo();
        
        this.dispositivo.asociarObservadorController(this);
    }
    
    private void vincularDispositivo(){
        this.dispositivo.setCliente(cliente);
    }
    
    public void loginCliente(String numero, String password, int idDispositivo){
        try{
            this.dispositivo.tengoCliente();
            
            Cliente c = Fachada.getInstancia().loginCliente(numero, password, idDispositivo);
            c.isLogged();
            
            this.setCliente(c);
            c.logIN();
            
            vista.mensaje("Bienvenido ", c.getNombreCompleto());
            vista.setTitulo(c.getNombreCompleto());
            
        }catch(IdentificacionException ex){
            vista.mensaje(ex.getMessage());
        }
    }
    
    private void mostrarPedidos(){
        ArrayList<Pedido> p = this.dispositivo.getPedidos();
        vista.mostrarPedidos(p);
    }
    
    private void actualizarCostoTotal() {
        vista.actualizarCostos(this.dispositivo.getCostos());
    }

    public void agregarPedido(Item item, String comentario) {
        try{
            validarCliente();
            validarItem(item);
            this.dispositivo.agregarPedido(item, comentario);
            
            vista.mensaje("Pedido agregado con Exito");
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Realizar Pedido");
        }catch(Exception ex){
            vista.mensaje(ex.getMessage());
        }
    }
    
    public void eliminarPedido(int indice) {
        try{
            validarCliente();
            validarIndice(indice);
            
            this.dispositivo.eliminarPedido(indice);
            
            vista.mensaje("Pedido eliminado con Exito");
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Eliminar Pedido");
        }catch(Exception ex){
            vista.mensaje(ex.getMessage());
        }
    }
    
    public void confirmarServicio() {        
        try{
            validarCliente();
            
            LocalDateTime fecha = LocalDateTime.now();
            this.dispositivo.confirmar(fecha);
            
            
            vista.mensaje("Servicio Confirmado");
        }catch(PedidoClienteException ex){
            vista.mensaje(ex.getMessage());
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Confirmar el Pedido");
        }
    }
    
    public void finalizarServicio() {
        try{
            validarCliente();
            
            if(this.dispositivo.hayPedidos()){
                validarPedidos();
            
                this.dispositivo.finalizar();
                vista.finalizado("Servicio Finalizado", this.dispositivo.pedidosNoEntregados() + this.dispositivo.beneficioAplicado() + "  Monto a Pagar: " + this.dispositivo.getFinal());
            }            
            
            //desvincular dispositivo
            this.dispositivo.desvincular();
            vista.inicializar();
            
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Finalizar Servicio");
        }catch(PedidoClienteException ex){
            vista.mensaje(ex.getMessage());
        }
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return Fachada.getInstancia().getCategorias();
    }
    
    public ArrayList<Item> obtenerItemsDeCategoria(Categoria c){
        ArrayList<Item> lista = c.obtenerItems();
        
        if(lista.isEmpty()){
            vista.mensaje("Lo sentimos. No contamos con stock disponible para esta categoria");
        }
        
        return lista;
    }

    private void validarCliente() throws UsuarioNULOException {
        if(this.cliente == null) throw new UsuarioNULOException("");
    }

    private void validarIndice(int indice) throws Exception{
        if(indice == -1) throw new Exception("Seleccione un pedido!");
    }

    private void validarItem(Item i) throws Exception{
        if(i == null) throw new Exception("Debe seleccionar un Item!");
    }

    
    private void validarPedidos() throws PedidoClienteException{
        this.dispositivo.pedidosConfirmados();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(EstadosSistema.ALTA_PEDIDO.equals(evento) || EstadosSistema.BAJA_PEDIDO.equals(evento) || EstadosSistema.CONFIRMADO.equals(evento)){
            //traer los pedidos
            this.mostrarPedidos();
            //actualizar el monto total
            this.actualizarCostoTotal();
        }
    }
}
