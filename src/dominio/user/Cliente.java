package dominio.user;

import excepciones.IdentificacionException;

public class Cliente extends Usuario{

    private boolean logged;
    private TipoCliente tipoCliente;

    
    public Cliente(String usuario, String contra){
        super(usuario, contra);
    }
    
    public Cliente(String usuario, String contra, String nombrecompleto){
        super(usuario, contra, nombrecompleto);
    }
    
    public Cliente(String usuario, String contra, String nombrecompleto, TipoCliente tipo){
        super(usuario, contra, nombrecompleto);
        this.setTipoCliente(tipo);
    }
    
    public TipoCliente getTipoCliente(){ return this.tipoCliente;}
        
    public void isLogged() throws IdentificacionException{
        if(this.logged) throw new IdentificacionException("Ud. ya está identificado en otro dispositivo");
    }

    public void logIN() {
        this.logged = true;
    }
    
    public void LogOUT(){ this.logged = false;}


    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
}
