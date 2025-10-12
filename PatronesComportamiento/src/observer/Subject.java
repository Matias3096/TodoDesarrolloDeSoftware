package observer;

public interface Subject {
    void agregarObservador(Observer observer);
    void removerObservador(Observer observer);
    void notificarObservadores(String mensaje, String tipoCambio);

}
