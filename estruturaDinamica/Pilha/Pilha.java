package estruturaDinamica.Pilha;

import java.util.NoSuchElementException;

public class Pilha<T> {
    private Celula<T> topo;
    private Celula<T> fundo;

    public Pilha() {
        Celula<T> sentinela = new Celula<T>();
        topo = fundo = sentinela;
    }

    public void empilhar(T item) {
        Celula<T> novoItem = new Celula<T>(item,topo);
        topo = novoItem;
    }

    public T desempilhar() {
        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }
        T item = topo.getItem();
        topo = topo.getProxima();

        return item;
    }

    public boolean vazia() {
        return fundo == topo; //fundo sempre eh a sentinela, se tiver so 1 item, topo estara 1 valor acima de fundo/sentinela
    }

    public void imprimir() {
        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }
        Celula<T> auxiliar = topo;
        while (!vazia()) {
            System.out.println(auxiliar);
            auxiliar = auxiliar.getProxima();
        }
    }
}
