package dominio.user;

import dominio.Unidad;
import dominio.Pedido;
import excepciones.IdentificacionException;
import excepciones.PedidoClienteException;
import java.util.ArrayList;

public class Gestor extends Usuario /*implements Observador*/{

    private Unidad unidad;
    private ArrayList<Pedido> pedidosAceptados;

    
    public Gestor(String usuario, String contra, String nombrecompleto, Unidad u){
        super(usuario, contra, nombrecompleto);
        this.unidad = u;
        this.pedidosAceptados = new ArrayList();
        //unidad.agregarObservador(this);
    }

    //para login
    public Gestor(String usuario, String password) {
        super(usuario, password);
    }
    
    public void setUnidad(Unidad u){
        this.unidad = u;
    }
    
    public Unidad getUnidad() {
        return this.unidad;
    }

    public String getNombre(){
        return this.getNombreCompleto();
    }
    
    public String getNombreUnidad(){
        return this.unidad.getUnidad();
    }

    public ArrayList<Pedido> pedidosDisponibles() {
        return this.unidad.pedidosDisponibles();
    }

    @Override
    public void yaEstoyLogeado() throws IdentificacionException {
        if(this.getLogged()) throw new IdentificacionException("Acceso denegado. El usuario ya está logueado");
    }

    /*
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(EstadosSistema.ACTUALIZAR.equals(evento)){
            //System.out.println("Soy gestor y me llegaron PEDIDOS");
        }
    }
*/

    public void tomarPedido(Pedido seleccionado){
        this.pedidosAceptados.add(seleccionado);
    }

    public ArrayList<Pedido> getPedidosTomados() {
        return this.pedidosAceptados;
    }

    public void finalizarPedido(int selectedRow) throws PedidoClienteException {
        Pedido p = this.pedidosAceptados.get(selectedRow);
        p.finalizarPedido();
    }

    public void entregarPedido(int selectedRow) throws PedidoClienteException {
        Pedido p = this.pedidosAceptados.get(selectedRow);
        p.entregarPedido();
    }

    public boolean pedidosTodosEntregados() {
        for(Pedido p : this.pedidosAceptados){
            if(!p.estoyEntregado()) return false;
        }
        return true;
    }

    public void limpiarPedidosAceptados() {
        this.pedidosAceptados.removeAll(pedidosAceptados);
    }

    public String getNombrecompleto() {
        return this.getNombreCompleto();
    }
    

}
