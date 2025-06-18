/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.EstadosSistema;
import dominio.Pedido;
import dominio.Unidad;
import dominio.observer.Observable;
import dominio.observer.Observador;
import dominio.user.Gestor;
import excepciones.IdentificacionException;
import excepciones.PedidoClienteException;
import java.util.ArrayList;
import servicio.Fachada;
import vista.VistaGestores;

/**
 *
 * @author Emiliano Barcosta
 */
public class GestorControlador implements Observador{
    
    private Gestor gestor;
    private VistaGestores vista;
    private Unidad unidad;
    
    public GestorControlador(VistaGestores v, Gestor g){
        this.gestor = g;
        this.vista = v;
        this.unidad = g.getUnidad();
        
        unidad.agregarObservador(this);
    }
    
    public void loginGestor(String numero, String password){
        try{
            //this.dispositivo.tengoCliente();
            Gestor g = Fachada.getInstancia().loginGestor(numero, password);
            g.yaEstoyLogeado();

        }catch(IdentificacionException ex){
            //vista.mensaje(ex.getMessage());
        }
    }

    public ArrayList<Pedido> obtenerPedidosUnidad() {
        return this.gestor.pedidosDisponibles();
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(EstadosSistema.ACTUALIZAR.equals(evento)){
            //traer los pedidos
            vista.cargarPedidosUnidad();
        }
    }

    public void procesarPedidoSeleccionado(Pedido seleccionado) throws PedidoClienteException {
        //Registra que ese pedido está siendo procesado por ese gestor
        seleccionado.setGestor(this.gestor);
        
        //lo agrega a la lista de pedidos tomados del gestor
        //cambia estado del pedido a EnProceso
        this.gestor.tomarPedido(seleccionado);
        
        //lo quita de la lista de pedidos pendientes
        this.unidad.pedidoTomado(seleccionado);
    }

}
