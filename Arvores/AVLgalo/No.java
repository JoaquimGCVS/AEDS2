package Arvores.AVLgalo;

public class No<T extends Comparable<T>> {
    private T item; // Elemento armazenado pelo No
    private No<T> esquerda; // Referencia para o filho da esquerda
    private No<T> direita; // Referencia para o filho da direita
    private int altura; // Altura deste No, para calcular o fator de balanceamento

    public No() { // Cria No vazio
        setItem(null);
        setEsquerda(null);
        setDireita(null);
        setAltura(0);
    }

    public No(T item) { // Cria No com um item, bom para Nos folha(sem filhos) ou raiz
        setItem(item);
        setEsquerda(null);
        setDireita(null);
        setAltura(0);
    }

    public No(T item, No<T> esquerda, No<T> direita) { // Cria Nos com referencias para filhos + item
        setItem(item);
        setEsquerda(esquerda);
        setDireita(direita);
        setAltura(0);
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

    public int getAltura() { // Retorna a altura deste No
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    private int getAltura(No<T> no) { // Retorna a altura de outro No, passado por parametro
        if (no==null) {
            return -1;
        } else {
            return no.getAltura();
        }
    }

    public void recalcularAltura() { // Calcula a altura deste No
        int alturaEsquerda = getAltura(esquerda);
        int alturaDireita = getAltura(direita);

        if (alturaEsquerda>alturaDireita) {
            altura = alturaEsquerda + 1;
        }
        else {
            altura = alturaDireita + 1;
        }
    }

    public int getFatorBalanceamento() { // Calcula o fator de balanceamento deste No
        int alturaEsquerda = getAltura(esquerda);
        int alturaDireita = getAltura(direita);

        return alturaEsquerda - alturaDireita;
    }

    
}
