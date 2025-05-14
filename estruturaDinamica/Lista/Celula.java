package estruturaDinamica.Lista;

public class Celula<T> {
    private T item;
    private Celula<T> proximaCelula;
    private int tamanho;

    public Celula() {}

    public Celula(T item, Celula<T> proxima) {
        setItem(item);
        setProximaCelula(proxima);
        tamanho = 0;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Celula<T> getProximaCelula() {
        return proximaCelula;
    }

    public void setProximaCelula(Celula<T> proximaCelula) {
        this.proximaCelula = proximaCelula;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
}
