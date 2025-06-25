package arvores.ABB;

import java.util.NoSuchElementException;

public class ABB<T extends Comparable<T>> {
    private No<T> raiz; //referencia a raiz da arvore

    public ABB() {
        this.raiz = null;
    }

    public boolean vazia() {
        return (this.raiz==null);
    }

    private T pesquisar(No<T> raizArvore, T chave) {
        if (raizArvore==null) {
            throw new NoSuchElementException("raiz is null!");
        }

        int comparacao = raizArvore.getItem().compareTo(chave); //compara com compareTo de Comparable

        if (comparacao==0) {
            return raizArvore.getItem();
        }
        else if (comparacao<0) {
            return pesquisar(raizArvore.getEsquerda(), chave); //chama recusrivamente para a esquerda, ja que o valor eh menor
        }
        else {
            return pesquisar(raizArvore.getDireita(), chave); //chama recusrivamente para a direita, ja que o valor eh maior
        }
    }

    public T pesquisar(T item) {
        return pesquisar(this.raiz, item);
    }

    private No<T> adicionar(No<T> raizArvore, T item) {
        if (raizArvore==null) {
            return new No<T>(item); //se a arvore tem raiz null, entao cria a raiz como No folha
        }

        int comparacao = item.compareTo(raizArvore.getItem());

        if (comparacao==0) {
            throw new RuntimeException("O item ja foi adicionado anteriormente");
        }
        else if (comparacao<0) {
            raizArvore.setEsquerda(adicionar(raizArvore.getEsquerda(), item));
        }
        else {
            raizArvore.setDireita(adicionar(raizArvore.getDireita(), item));
        }

        return raizArvore;
    }

    public void adicionar(T item) {
        this.raiz = adicionar(this.raiz, item);
    }

    private void caminhamentoEmOrdem(No<T> raizArvore) {
        if (raizArvore!=null) { 
            caminhamentoEmOrdem(raizArvore.getEsquerda());
            System.out.println(raizArvore.getItem());
            caminhamentoEmOrdem(raizArvore.getDireita());
        }
    }

    public void caminhamentoEmOrdem() {
        if (vazia()) {
            throw new IllegalStateException("A arvore esta vazia!");
        }
        caminhamentoEmOrdem(this.raiz);
    }

    private No<T> removerNoAntecessor(No<T> noRetirar, No<T> raizArvore) { // raiz arvore aqui seria o No da esquerda do que vai ser retirado
        if (raizArvore.getDireita()!=null) {
            raizArvore.setDireita(removerNoAntecessor(noRetirar, raizArvore.getDireita()));
        }
        else {
            noRetirar.setItem(raizArvore.getItem()); // pega o valor do antecessor que vai ser retirado
            raizArvore = raizArvore.getEsquerda(); // substitui pela raiz arvore
        }
        return raizArvore;
    }

    private No<T> remover(No<T> raizArvore, T chave) {
        if (raizArvore == null) {
            throw new NoSuchElementException("Item não encontrado");
        }
        int comparacao = chave.compareTo(raizArvore.getItem());

        if (comparacao==0) {
            if (raizArvore.getDireita()==null) {
                raizArvore = raizArvore.getEsquerda();
            }
            else if (raizArvore.getEsquerda()==null) {
                raizArvore = raizArvore.getDireita();
            }
            else {
                raizArvore.setEsquerda(removerNoAntecessor(raizArvore, raizArvore.getEsquerda()));
            }
        }
        else if (comparacao<0) {
            raizArvore.setEsquerda(remover(raizArvore.getEsquerda(), chave));
        }
        else {
            raizArvore.setDireita(remover(raizArvore.getDireita(), chave));
        }

        return raizArvore;
    }

    public void remover(T chave) {
        this.raiz = remover(this.raiz, chave);
    }

    public T obterSucessor(T item) {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vazia");
        }
        No<T> noDoItem = pesquisarNoRec(item, raiz);
        return obterSucessorRec(noDoItem.getDireita());
    }

    private No<T> pesquisarNoRec(T item, No<T> raizArvore) {
        if (raizArvore.getItem().compareTo(item)==0) {
            return raizArvore;
        }
        else if (item.compareTo(raizArvore.getItem())<0) {
            return pesquisarNoRec(item, raizArvore.getEsquerda());
        }
        return pesquisarNoRec(item, raizArvore.getDireita());
    }

    private T obterSucessorRec(No<T> raizArvore) {
        if (raizArvore==null) {
            throw new NoSuchElementException("A arvore nao tem sucessor");
        }
        else if (raizArvore.getEsquerda()!=null) {
            return obterSucessorRec(raizArvore.getEsquerda());
        }
        return raizArvore.getItem();
    }
}
