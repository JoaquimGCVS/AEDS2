package estruturaDinamica.Lista;

public class Celula<E> {
    private E item;
    private Celula<E> proxima;

    public Celula (E item) {
        setItem(item);
        setProxima(proxima);
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Celula<E> getProxima() {
        return proxima;
    }

    public void setProxima(Celula<E> proxima) {
        this.proxima = proxima;
    }

    
}
