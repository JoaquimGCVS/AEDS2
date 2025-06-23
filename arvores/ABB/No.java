package arvores.ABB;

public class No<T extends Comparable<T>> { //garante que os objetos armazenados nos Nos sejam comparaveis entre si
    private T item; //dado armazenado no No
    private No<T> esquerda; //referencia para filho da esquerda
    private No<T> direita; //referencia para filho da direita
    private int altura; //altura deste No (0,1,2)

    public No() { //construtor padrao
        setItem(null);
        setEsquerda(null);
        setDireita(null);
        this.altura = 0;
    }

    public No(T item) { //construtor para folha
        setItem(item);
        setEsquerda(null);
        setDireita(null);
        this.altura = 0;
    }

    public No(T item, No<T> esquerda, No<T> direita) {
        setItem(item);
        setEsquerda(esquerda);
        setDireita(direita);
        this.altura = 0;
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

    private int getAlturaPorParametro(No<T> no) {
        if (no!=null) {
            return no.getAltura();
        }
        return -1;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura() {
        int alturaEsquerda = getAlturaPorParametro(this.getEsquerda());
        int alturaDireita = getAlturaPorParametro(this.getDireita());

        if (alturaDireita>alturaEsquerda) {
            this.altura = alturaDireita+1;
        }
        else {
            this.altura = alturaEsquerda+1;
        }
    }

    public int getFatorBalanceamento() {
        int alturaEsquerda = getAlturaPorParametro(this.getEsquerda());
        int alturaDireita = getAlturaPorParametro(this.getDireita());

        return alturaEsquerda-alturaDireita;
    }

}
