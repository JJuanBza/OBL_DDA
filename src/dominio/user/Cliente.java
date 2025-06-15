package dominio.user;

import dominio.Servicio;
import excepciones.IdentificacionException;

public class Cliente extends Usuario{

    private boolean logged;

    //private Servicio servicio;

    private TipoCliente tipoCliente;

    
    public Cliente(String usuario, String contra){
        super(usuario, contra);
    }
    
    public Cliente(String usuario, String contra, String nombrecompleto){
        super(usuario, contra, nombrecompleto);
    }
        
    public void isLogged() throws IdentificacionException{
        if(this.logged) throw new IdentificacionException("Ud. ya está identificado en otro dispositivo");
    }

    public void logIN() {
        this.logged = true;
    }
    
    public void LogOUT(){ this.logged = false;}

    /*
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
*/

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /*
    public float calcularMontoBeneficio(){
        return this.tipoCliente.calcularMontoConBeneficios(servicio);
    }
*/
    
    
}
