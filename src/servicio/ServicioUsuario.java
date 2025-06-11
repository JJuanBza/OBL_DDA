package servicio;

import dominio.Unidad;
import dominio.user.Cliente;
import dominio.user.Usuario;
import dominio.user.Gestor;
import java.util.ArrayList;

public class ServicioUsuario {

    //private ArrayList<Usuario> usuarios; ???
    
    private ArrayList<Usuario> clientes;
    
    private ArrayList<Usuario> gestores;
    
    public ServicioUsuario(){
        this.clientes = new ArrayList();
        this.gestores = new ArrayList();
    }
    
    public Cliente loginCliente(String usuario, String password){
        Cliente encontrado = (Cliente) this.buscarUsuario(clientes, new Cliente(usuario, password));
        return encontrado;
    };
    
    public Gestor loginGestor(String usuario, String password){
        Gestor encontrado = (Gestor) this.buscarUsuario(gestores, new Gestor(usuario, password));
        
        return encontrado;
    };
    
    private Usuario buscarUsuario(ArrayList<Usuario> list, Usuario buscado){
        for(Usuario u : list){
            if(u.equals(buscado)) return u;
        }
        
        return null;
    }
    

    private void logout(){};
    
    public void agregarCliente(String user, String pass, String nomCompleto){
        this.clientes.add(new Cliente(user, pass, nomCompleto));
    }
    
    public void agregarGestor(String user, String pass, String nomCompleto, Unidad u){
        this.gestores.add(new Gestor(user, pass, nomCompleto, u));
    }
}
