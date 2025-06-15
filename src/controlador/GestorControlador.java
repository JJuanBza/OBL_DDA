/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.observer.Observable;
import dominio.observer.Observador;
import dominio.user.Gestor;
import excepciones.IdentificacionException;
import servicio.Fachada;
import vista.VistaGestores;

/**
 *
 * @author Emiliano Barcosta
 */
public class GestorControlador implements Observador{
    private Fachada fachada;
    
    private Gestor gestor;
    private VistaGestores vista;
    
    public GestorControlador(){
        this.fachada = Fachada.getInstancia();
    }
    
    public void loginGestor(String numero, String password){
        try{
            //this.dispositivo.tengoCliente();
            
            Gestor g = Fachada.getInstancia().loginGestor(numero, password);

        }catch(IdentificacionException ex){
            System.out.println(ex);
            //vista.mensaje(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
