/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.beneficios;
import dominio.Servicio;

/**
 *
 * @author 05147
 */
public abstract class Beneficio {    
    
    private boolean aplicado;
    
    public abstract String descripcion();
    public abstract double calcular(Servicio s);
    public abstract boolean fuiAplicado();
}
