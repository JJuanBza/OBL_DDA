/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

import java.util.ArrayList;

/**
 *
 * @author Emiliano Barcosta
 */
public class ValidacionMultipleException extends Exception {
    private ArrayList<String> errores;
    
    public ValidacionMultipleException(){
        super();
        this.errores = new ArrayList();
    }

    public ValidacionMultipleException(ArrayList<String> errores) {
        super();
        this.errores = errores;
    }

    public ArrayList<String> getErrores() {
        return errores;
    }
    
    public void addErrores(String error){
        this.errores.add(error);
    }

    @Override
    public String getMessage() {
        return String.join("\n", errores);
    }
}

