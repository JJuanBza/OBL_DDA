package dominio.user;

import dominio.Servicio;
import dominio.beneficios.Beneficio;
import java.util.ArrayList;

public class TipoCliente {
    private String nombre;
    private ArrayList<Beneficio> beneficios;

    public TipoCliente(String nombre) {
        this.nombre = nombre;
        this.beneficios = new ArrayList();
    }

    public void agregarBeneficio(Beneficio b){
        this.beneficios.add(b);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Beneficio> getBeneficios() {
        return beneficios;
    }
    
    public float calcularMontoConBeneficios(Servicio s) {
    float totalBeneficios = 0;
    for (Beneficio b : beneficios) {
        totalBeneficios += b.calcular(s); // cada beneficio usa la lógica que necesita
    }
    return s.getMontoTotal() - totalBeneficios;
}
}
