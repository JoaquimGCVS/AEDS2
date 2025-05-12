package estruturaDinamica.Fila;

public class Fila<E> {
    private Celula<E> frente; //inicio
    private Celula<E> tras; //final
    private int tamanho;

    public Fila() {
        frente = null;
        tras = null;
        tamanho = 0;
    }

    public void enfileirar(E item) { //adiciona um novo item E/Celula no final da fila
        Celula<E> novoItem = new Celula<E>(item);
        if (vazia()) {
            frente = novoItem; 
        } else {
            tras.setProximoItem(novoItem);
        }
        tras = novoItem;
        tamanho++;
    }


    public E desenfileirar() {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        E item = frente.getItem();
        frente = frente.getProximoItem();
        if (vazia()) {
            tras = null;
        }
        tamanho--;

        return item;
    }

    public boolean vazia() {
        return frente == null; //se o incio da fila for nao tiver nenhum item, entao ela esta vazia
    }

    public E consultarPrimeiro() {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        E item = frente.getItem();
        return item;
    }

    public void imprimir() {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        Celula<E> auxiliar = frente;
        while (!vazia()) { //percorre a fila ate ficar vazia
            System.out.println(auxiliar.getItem());
            auxiliar = auxiliar.getProximoItem(); //atualiza a variavel auxiliar para a proxima celula da fila
        }
    }

}
