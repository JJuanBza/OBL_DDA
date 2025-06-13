/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.user.Gestor;
import servicio.Fachada;

/**
 *
 * @author Emiliano Barcosta
 */
public class GestorControlador {
    Fachada fachada;
    
    public GestorControlador(){
        this.fachada = Fachada.getInstancia();
    }
    
    public Gestor loginGestor(String numero, String password){
        return this.fachada.loginGestor(numero, password);
    }
}
