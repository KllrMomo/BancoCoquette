
package bankcoquette;

public class NodoSE<T> {
    private T dato;
    
    private NodoSE<T> siguiente;

    public NodoSE<T> getSiguiente () {
        return siguiente;
    }
    
    public void setSiguiente (NodoSE<T> siguienteE) {
        this.siguiente = siguienteE;
    }
    
    public T getDato () {
        return dato;
    }
    
    public void setDato (T dato) {
        this.dato = dato;
    }
    
    public NodoSE(T dato, NodoSE<T> pSiguiente) {
        this.dato = dato;
        this.siguiente = pSiguiente;
    }
    
    public NodoSE (T pDato) {
        this.dato = pDato;
        this.siguiente = null;
    }
    
}
