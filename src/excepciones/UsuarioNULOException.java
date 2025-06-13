/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Emiliano Barcosta
 */
public class UsuarioNULOException extends Exception{
    
    public UsuarioNULOException(String accion){
        super("Debe Indentificarse antes de " + accion);
    }
}
