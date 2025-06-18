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
import dominio.beneficios.Gratis;
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
        
        
        fachada.agregarGestor("pastel", "123", "William", ChefPastelero);
        fachada.agregarGestor("p", "123", "el Brayan", ChefPastelero);
        
        
        
        // --- Unidades procesadoras ---
        Unidad cocina = new Unidad("Cocina");
        Unidad bar = new Unidad("Bar");

        // --- Clientes ---
        TipoCliente comun = new TipoCliente("Común");
        TipoCliente deLaCasa = new TipoCliente("De la casa");
        deLaCasa.agregarBeneficio(new Gratis(500));

        fachada.agregarCliente("c", "c", "Pedro Peña", comun);
        fachada.agregarCliente("d", "d", "Laura Lamas", deLaCasa);

        // --- Gestores ---
        fachada.agregarGestor("cocinero", "123", "Carlos Cocina", cocina);
        fachada.agregarGestor("barman", "123", "Bruno Bar", bar);

        // --- Categorías ---
        Categoria principal = new Categoria("Plato Principal");
        Categoria bebidas = new Categoria("Bebidas");

        fachada.agregarCategoria(principal);
        fachada.agregarCategoria(bebidas);

        // --- Insumos ---
        Insumo carne = new Insumo("Carne vacuna", 3, 10);
        Insumo papas = new Insumo("Papas", 5, 10); // stock bajo para test
        Insumo agua = new Insumo("Agua mineral", 10, 20);
        Insumo cafe = new Insumo("Café", 5, 50);
        Insumo gin = new Insumo("Gin", 2, 10);
        Insumo tonica = new Insumo("Tónica", 2, 10);

        // --- Ítems y sus ingredientes ---
        Item milanesa = new Item("Milanesa con fritas", cocina, principal, 800);
        milanesa.agregarIngrediente(new Ingrediente(carne, 1));
        milanesa.agregarIngrediente(new Ingrediente(papas, 3));
        principal.agregarItem(milanesa);

        Item ginTonic = new Item("Gin Tonic", bar, bebidas, 600);
        ginTonic.agregarIngrediente(new Ingrediente(gin, 1));
        ginTonic.agregarIngrediente(new Ingrediente(tonica, 1));
        bebidas.agregarItem(ginTonic);

        Item aguaMineral = new Item("Agua Mineral", bar, bebidas, 100);
        aguaMineral.agregarIngrediente(new Ingrediente(agua, 1));
        bebidas.agregarItem(aguaMineral);

        Item cafeSolo = new Item("Café", bar, bebidas, 150);
        cafeSolo.agregarIngrediente(new Ingrediente(cafe, 1));
        bebidas.agregarItem(cafeSolo);
        
        
        
        new MenuDesarrollador().setVisible(true);
    }
    
}
