public class No<T> {
    private T item;
    private No<T> esquerda;
    private No<T> direita;

    public No(T item) {
        setItem(item);
        esquerda = direita = null;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    public int grau() {
        int grau = 0; //quantidade de filhos
        if ((esquerda == null) && (direita==null)) {
            return 0;
        }
        if (esquerda!=null) {
            grau++;
        }
        if (direita!=null) {
            grau++;
        }
        return grau;
    }
 }