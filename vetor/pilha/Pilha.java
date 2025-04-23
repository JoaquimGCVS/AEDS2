package vetor.pilha;

import java.util.NoSuchElementException;

public class Pilha<E> {
    private int topo;
    private E[] pilha;

    @SuppressWarnings("unchecked")
    public Pilha(int tamanho) {
        topo =0;
        pilha = (E[]) new Object[tamanho];
    }

    public boolean vazia() {
        return (topo==0);
    }
    
    public boolean cheia() {
        return (topo==pilha.length);
    }

    public void empilhar(E item) {
        if (cheia()) {
            throw new IllegalStateException("A pilha esta cheia!");
        }
        pilha[topo-1] = item;
        topo++;
    }

    public  E consultarTopo() {
        if(vazia()) {
            throw new NoSuchElementException("A pliha esta vazia!");
        }
        return pilha[topo];
    }

    public void desemplihar() {
        if(vazia()) {
            throw new NoSuchElementException("A pliha esta vazia!");
        }
        topo--;
        pilha[topo] = null;
    }
}
