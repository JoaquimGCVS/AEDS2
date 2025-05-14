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
        while (auxiliar!=fundo) {
            System.out.println(auxiliar);
            auxiliar = auxiliar.getProxima();
        }
    }

    public void inverter() {
        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }

        Pilha<T> aux = new Pilha<>();
        while (!vazia()) {
            aux.empilhar(this.desempilhar());
        }
        this.topo = aux.topo;
    }


    public Pilha<T> concatenar (Pilha<T> pilha) {
        if (pilha.vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }
        pilha.inverter();
        while (!pilha.vazia()) {
            this.empilhar(pilha.desempilhar());
        }
        return this;
    }

    public int obterNumeroItens() {
        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }

        int cont = 0;
        Celula<T> atual = topo;
    
        while (atual!=fundo) {
            cont++;
            atual = atual.getProxima();
        }

        return cont;
    }

    public boolean palindromo(String palavra) {
        Pilha<Character> pilha = new Pilha<>();
        
        for (char c : palavra.toCharArray()) {
            pilha.empilhar(c);
        }

        for (char c : palavra.toCharArray()) {
            if (c != pilha.desempilhar()) {
                return false;
            }
        }
        return true;
    }
}
