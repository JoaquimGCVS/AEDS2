package Atividades.arvores;

public class No<K,V> {
    
    private K chave; //chave para Hash
    private V valor; //dado armazenado
    private No<K,V> esquerda; //referencia para filho esquerdo
    private No<K,V> direita; //referencia para filho direito
    private int altura; //altura deste No

    public No(K chave, V valor) {
        setChave(chave);
        setValor(valor);
        setEsquerda(null);
        setDireita(null);
        this.altura = 0;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public No<K, V> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<K, V> esquerda) {
        this.esquerda = esquerda;
    }

    public No<K, V> getDireita() {
        return direita;
    }

    public void setDireita(No<K, V> direita) {
        this.direita = direita;
    }

    public int getAltura(No<K,V> no) { //retorna a altura de outro No por parametro
        if (no==null) {
            return -1;
        }

        return no.getAltura();
    }

    public int getAltura() { //retorna a altura deste No
        return altura;
    }

    public void setAltura() { //recalcula a altura deste No
        int alturaEsquerda = getAltura(this.getEsquerda());
        int alturaDireita = getAltura(this.getDireita());

        if (alturaEsquerda>alturaDireita) {
            this.altura = alturaEsquerda+1;
        }
        else {
            this.altura = alturaDireita+1;
        }
    }

    public int getFatorBalanceamento() { //altura da subarvore esquerda - altura da subarvore direita
        int alturaEsquerda = getAltura(this.getEsquerda());
        int alturaDireita = getAltura(this.getDireita());

        return alturaEsquerda-alturaDireita;
    }
}
