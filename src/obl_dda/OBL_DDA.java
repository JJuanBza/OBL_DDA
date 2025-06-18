/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obl_dda;



import dominio.Categoria;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.Item;
import dominio.Unidad;
import dominio.beneficios.Descuento;
import dominio.beneficios.ProductoGratis;
import dominio.user.TipoCliente;
import servicio.Fachada;
import vista.MenuDesarrollador;

/**
 *
 * @author Emiliano Barcosta
 */
public class OBL_DDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Fachada fachada = Fachada.getInstancia();
        
        Unidad ChefPastelero = new Unidad("Pâtissier");
        
        
        Categoria postres = new Categoria("Postres");
        
        
        Insumo arroz = new Insumo("Arroz", 2, 20);
        Insumo leche = new Insumo("Leche", 5, 15);
        Insumo azucar = new Insumo("Azucar", 1, 17);
        Insumo canela = new Insumo("Canela", 10, 100);
        
        Ingrediente arrozIng = new Ingrediente(arroz, 0.200);
        Ingrediente lecheIng = new Ingrediente(leche, 2);
        Ingrediente azucarIng = new Ingrediente(azucar, 0.150);
        Ingrediente canelaIng = new Ingrediente(canela, 2);
        
        Item arrozConLeche = new Item("Arroz con Leche", ChefPastelero, postres, 500);
        arrozConLeche.agregarIngrediente(arrozIng);
        arrozConLeche.agregarIngrediente(lecheIng);
        arrozConLeche.agregarIngrediente(azucarIng);
        arrozConLeche.agregarIngrediente(canelaIng);
        
        postres.agregarItem(arrozConLeche);
        
        Insumo dulceMembrillo = new Insumo("Dulce de Membrillo", 1, 15);
        Insumo quesoCremoso = new Insumo("Queso Colonia", 1, 21);
        
        Ingrediente dmIng = new Ingrediente(dulceMembrillo, 0.200);
        Ingrediente qcIng = new Ingrediente(quesoCremoso, 0.200);
        
        Item martinFierro = new Item("Martin Fierro", ChefPastelero, postres, 500);
        martinFierro.agregarIngrediente(qcIng);
        martinFierro.agregarIngrediente(dmIng);
        
        postres.agregarItem(martinFierro);
        
        fachada.agregarCategoria(postres);
   
        //Insumo cafe = new Insumo("Granos Cafe", 2, 14);
        
        
        
        TipoCliente frecuente = new TipoCliente("Frecuente");
        frecuente.agregarBeneficio(new ProductoGratis(martinFierro));
        
        TipoCliente preferencial = new TipoCliente("Preferencial");
        preferencial.agregarBeneficio(new ProductoGratis(martinFierro));
        preferencial.agregarBeneficio(new Descuento(2000, 0.05));
        
        fachada.agregarCliente("a", "a", "Juan Barboza", frecuente);
        fachada.agregarCliente("b", "b", "Valtasar Blum", preferencial);
        
        
        fachada.agregarGestor("w", "w", "William", ChefPastelero);
        
        new MenuDesarrollador().setVisible(true);
    }
    
}
