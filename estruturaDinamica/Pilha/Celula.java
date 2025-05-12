package estruturaDinamica.Pilha;

public class Celula<T> {
    private T item;
    private Celula<T> proxima;

    public Celula() {
    }

    public Celula(T item, Celula<T> proxima) {
        setItem(item);
        setProxima(proxima);
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Celula<T> getProxima() {
        return proxima;
    }

    public void setProxima(Celula<T> proxima) {
        this.proxima = proxima;
    }

    
}
