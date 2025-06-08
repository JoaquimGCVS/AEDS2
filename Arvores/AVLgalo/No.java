package Arvores.AVLgalo;

public class No<T extends Comparable> {

    private T item; //dado armazenado no No
    private No<T> direita; //Referencia para filho a direita
    private No<T> esquerda; //Referencia para filho a esquerda
    private int altura; //Altura deste No, usado para realizar o balanceamento AVL

    public No() { //Construtor para No vazio
        setItem(null);
        setDireita(null);
        setEsquerda(null);
        setAltura(0);
    }

    public No(T item) { //Construtor que recebe item
        setItem(item);
        setDireita(null);
        setEsquerda(null);
        setAltura(0);
    }

    public No(T item, No<T> direita, No<T> esquerda) { // Construtor que recebe item, esquerda e direita
        setItem(item);
        setDireita(direita);
        setEsquerda(esquerda);
        setAltura(altura);
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public int getAltura() {
        return altura;
    }

    // Verifica a altura de um No passado por parametro
    private int getAltura(No<T> no) {
        if (no==null) { // Se o No for null(sem filho) retorna -1, indicando que o outro caminho eh maior ou igual a -1 tambem
            return -1;
        }
        return no.getAltura();
    }

    public void setAltura() {
        int alturaEsquerda = getAltura(esquerda);
        int alturaDireita = getAltura(direita);

        // Verifica quald dois dois lados tem maior altura para calcular altura correta
        if (alturaEsquerda>alturaDireita) {
            altura = alturaEsquerda + 1; // Adiciona 1 referente a altura deste No
        } else {
            altura = alturaDireita + 1;
        }
        
    }

    // Calcula o fator de balanceamento deste No
    public int getFatorBalanceamento() {
        int alturaEsquerda = getAltura(esquerda);
        int alturaDireita = getAltura(direita);

        return alturaEsquerda-alturaDireita;
    }
    
}
