package dominio.observer;

import java.util.ArrayList;

public abstract class Observable {

    private ArrayList<Observador> observadores = new ArrayList();

    public void agregarObservador(Observador o) {
        this.observadores.add(o);
    }

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    public void avisar(Object evento) {
        for (int i = observadores.size() - 1; i >= 0; i--) {
            observadores.get(i).actualizar(this, evento);
        }
    }

}
