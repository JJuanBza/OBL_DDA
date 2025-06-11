package dominio.user;

import dominio.user.Gestor;
import java.util.Objects;

public abstract class Usuario {

    private String usuario;

    private String password;

    private String nombreCompleto;
    
    
    public Usuario(String user, String pass){
        this.usuario = user;
        this.password = pass;
    }
    
    public Usuario(String user, String pass, String nomCom){
        this.usuario = user;
        this.password = pass;
        this.nombreCompleto = nomCom;
    }
    
    public String getNombreCompleto(){
        return this.nombreCompleto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

}
