/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beneficios;

import dominio.Servicio;

/**
 *
 * @author 05147
 */
public interface Beneficio {
    String descripcion();
    float calcular(Servicio s);
}
