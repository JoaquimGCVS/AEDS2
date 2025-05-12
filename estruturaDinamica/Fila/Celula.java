package estruturaDinamica.Fila;

public class Celula<E> {
    private E item;
    private Celula<E> proximoItem;
    
    public Celula (E item) {
        this.item = item;
        proximoItem = null;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Celula<E> getProximoItem() {
        return proximoItem;
    }

    public void setProximoItem(Celula<E> proximoItem) {
        this.proximoItem = proximoItem;
    }
    
}
