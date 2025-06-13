/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Categoria;
import dominio.Dispositivo;
import dominio.observer.Observador;
import dominio.user.Cliente;
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
    
    public Cliente loginCliente(String numero, String password, int idDispositivo){
        return Fachada.getInstancia().loginCliente(numero, password, idDispositivo);
    }

    public void agregarPedido(Cliente cliente, Dispositivo dispositivo) {
        
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return Fachada.getInstancia().getCategorias();
    }
}
