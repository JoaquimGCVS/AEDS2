package estruturaDinamica.Fila;

public class Fila<E> {
    private Celula<E> frente; //inicio
    private Celula<E> tras; //final

    public Fila() {
        frente = null;
        tras = null;
    }

    public void enfileirar(E item) { //adiciona um novo item E/Celula no final da fila
        Celula<E> novoItem = new Celula<E>(item);
        if (vazia()) {
            frente = novoItem; 
        } else {
            tras.setProximoItem(novoItem);
        }
        tras = novoItem;
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

    public void concatenar (Fila<E> fila) {
        if (fila.vazia()) {
            throw new IllegalStateException("A fila passada está vazia.");
        }

        Celula<E> aux = fila.frente;
        while (aux!=fila.tras || aux == fila.tras) {
            this.enfileirar(aux.getItem());
            aux = aux.getProximoItem();
        }
    }

    public int obterNumeroItens() {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        Celula<E> aux = frente;
        int cont = 0;

        while (aux!=tras || aux==tras) {
            cont++;
            aux = aux.getProximoItem();
        }

        return cont;
    }

    public boolean verificarExistencia(E item) {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        Celula<E> aux = this.frente;
        while (aux != null) {
            if (aux.getItem().equals(item)){ //tipo generico deve usar equals()
                return true;
            }
            aux = aux.getProximoItem();
        }

        return false;
    }


    public int obterNumItensAFrente(E item) throws Exception {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        int cont=0;
        Celula<E> aux = this.frente;
        boolean achou = false;
        while (aux!=null) {
            if (aux.getItem().equals(item)) {
                achou = true;
                break;
            }
            
            cont++;
            aux = aux.getProximoItem();
        }

        if (!achou) {
            throw new  Exception("O item não foi localizado na fila.");
        }

        return cont;
    }

    public Fila<E> copiar() {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        Fila<E> copia = new Fila<>();
        Celula<E> aux = this.frente;

        while (aux!=null) {
            copia.enfileirar(aux.getItem());
            aux = aux.getProximoItem();
        }

        return copia;
    }
    
    // Implemente a função public Fila<E> dividir(), capaz de dividir a fila original
    // em duas, da seguinte forma: devem permanecer na fila atual os itens que ocupam,
    // atualmente, posição ímpar nessa fila. Devem ser enfileirados, na fila que será retornada por
    // esse método, os itens que ocupam, atualmente, posição par na fila original. Considere que
    // o primeiro item da fila (item localizado após a célula sentinela), ocupa a posição 0.

    public Fila<E> dividir() {
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        Fila<E> filaPar = new Fila<>();
        Fila<E> filaImpar = new Fila<>();

        Celula<E> aux = this.frente;
        int i = 0;

        while (aux!=null) {
            if (i%2 == 0) {
                filaPar.enfileirar(aux.getItem());
            } else {
                filaImpar.enfileirar(aux.getItem());
            }
            i++;
            aux = aux.getProximoItem();
        }

        this.frente = null;
        this.tras = null;

        aux = filaImpar.frente;
        while (aux!=null) {
            this.enfileirar(aux.getItem());
            aux = aux.getProximoItem();
        }

        return filaPar;
    }
}
