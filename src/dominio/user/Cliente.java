package dominio.user;

import excepciones.IdentificacionException;

public class Cliente extends Usuario{

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

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void yaEstoyLogeado() throws IdentificacionException {
        if(this.getLogged()) throw new IdentificacionException("Ud. ya está identificado en otro dispositivo");
    }
    
    
}
