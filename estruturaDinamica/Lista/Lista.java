package estruturaDinamica.Lista;

public class Lista<E> {
    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;


    public Lista() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void inserir(E item) {
        if (vazia()) {
            throw new IllegalStateException("A lista esta vazia!");
        }

        Celula<E> novaCelula = new Celula<E>(item);
        if (primeiro == null) {
            primeiro = novaCelula;
        } else {
            ultimo.setProxima(novaCelula);
        }
        ultimo = novaCelula;
        tamanho++;
    }

    public E remover(E item) {        
        Celula<E> aux = primeiro;
        Celula<E> anterior = null;
        while (aux!=null) {
            if (aux.getItem().equals(item)) {
                if (anterior==null) { //quer dizer que ele eh o primeiro item, ja que anterior nao foi modificado
                    primeiro= aux.getProxima();
                    if (primeiro == null) {
                        ultimo = null;
                    }
                } else {
                    anterior.setProxima(aux.getProxima());
                    if (aux == ultimo) {
                        ultimo = anterior;
                    }
                }
                tamanho--;
                return aux.getItem();
            } 
            anterior = aux;
            aux = aux.getProxima();
        }
        throw new IllegalStateException("O item nao foi removido com sucesso!");
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public E localizar(E procurado) {
        if (vazia()) {
            throw new IllegalStateException("A lista esta vazia");
        }
        Celula<E> aux = primeiro;
        while(aux!=null) {
            if (aux.getItem().equals(procurado)) {
                return aux.getItem();
            }
            aux = aux.getProxima();
        }
        throw new IllegalStateException("O item nao foi encontrado");
    }


    public void inserirFinal(E item) {
    Celula<E> novaCelula = new Celula<E>(item);
    if (vazia()) {
        primeiro = novaCelula;
        ultimo = novaCelula;
    } else {
        ultimo.setProxima(novaCelula);
        ultimo = novaCelula;
    }
    tamanho++;
}

public void inserir(E item, int posicao) {
    if (posicao < 0 || posicao > tamanho) {
        throw new IndexOutOfBoundsException("Posição inválida!");
    }
    Celula<E> novaCelula = new Celula<E>(item);
    if (posicao == 0) {
        novaCelula.setProxima(primeiro);
        primeiro = novaCelula;
        if (tamanho == 0) {
            ultimo = novaCelula;
        }
    } else {
        Celula<E> aux = primeiro;
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.getProxima();
        }
        novaCelula.setProxima(aux.getProxima());
        aux.setProxima(novaCelula);
        if (novaCelula.getProxima() == null) {
            ultimo = novaCelula;
        }
    }
    tamanho++;
}

public void mesclarListas(Lista<E> outraLista) {
    Celula<E> atual = this.primeiro;
    Celula<E> outraAtual = outraLista.primeiro;

    int i = 0;
    while (outraAtual!=null) {
        if (atual!=null) {
            if(i%2!=0) {
                this.inserir(outraAtual.getItem(), i); //insere nas posicoes impares
                outraAtual = outraAtual.getProxima();
            }
            atual = atual.getProxima();
        } else {
            this.inserirFinal(outraAtual.getItem());
            outraAtual = outraAtual.getProxima();
        }
        i++;
    }

}

}
    


































