/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Categoria;
import dominio.Dispositivo;
import dominio.Item;
import dominio.observer.Observador;
import dominio.user.Cliente;
import excepciones.UsuarioNULOException;
import java.util.ArrayList;
import servicio.Fachada;
import vista.Clientes;

/**
 *
 * @author Emiliano Barcosta
 */
public class ClienteControlador extends Observador{
    
    private Cliente cliente;
    private Clientes vista;
    
    
    public ClienteControlador(Cliente c, Clientes vista){
        this.cliente = c;
        this.vista = vista;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cliente loginCliente(String numero, String password, int idDispositivo){
        return Fachada.getInstancia().loginCliente(numero, password, idDispositivo);
    }

    public void agregarPedido(Dispositivo dispositivo, Item item, String comentario) {
        try{
            System.out.println(cliente == null);
            validarCliente();
            validarItem(item);
            dispositivo.agregarPedido(item, comentario);
            
            vista.mensaje("Pedido agregado con Exito");
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Realizar Pedido");
        }catch(Exception ex){
            vista.mensaje(ex.getMessage());
        }
    }
    
    public void eliminarPedido(Dispositivo dispositivo, int indice) {
        try{
            validarCliente();
            validarIndice(indice);
            
            vista.mensaje("Pedido eliminado con Exito");
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Eliminar Pedido");
        }catch(Exception ex){
            vista.mensaje(ex.getMessage());
        }
    }
    
    public void confirmarServicio(Dispositivo dispositivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void finalizarServicio(Dispositivo dispositivo) {
        try{
            validarCliente();
            validarPedidos(dispositivo);
            
            
        }catch(UsuarioNULOException ex){
            vista.mensaje(ex.getMessage(), "Finalizar Servicio");
        }catch(Exception ex){
            vista.mensaje(ex.getMessage());
        }
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return Fachada.getInstancia().getCategorias();
    }

    private void validarCliente() throws UsuarioNULOException {
        if(this.cliente == null) throw new UsuarioNULOException("");
    }

    private void validarIndice(int indice) throws Exception{
        if(indice == -1) throw new Exception("Seleccione un pedido PERRA");
    }

    private void validarItem(Item i) throws Exception{
        if(i == null) throw new Exception("Debe seleccionar un Item");
    }

    private void validarPedidos(Dispositivo dispositivo) throws Exception{
        //existen pedidos en el dispositivo
        if(!dispositivo.validarPedidos()) throw new Exception("No hay pedidos nuevos");
    }

}
