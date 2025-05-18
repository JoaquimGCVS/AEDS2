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

    public E localizar(E procurado) {

        if (vazia()) {
            throw new IllegalStateException("A lista esta vazia!");
        }
        Celula<E> aux = primeiro;
        while (aux!= null) {
            if (aux.getItem().equals(procurado)) {
                break;
            }
            aux = aux.getProxima();
        }

        if (aux==null) {
            throw new IllegalStateException("O objeto procurado nao foi encontrado");
        }

        return aux.getItem();
    }

    public boolean vazia() {
        return primeiro == null;
    }


}
