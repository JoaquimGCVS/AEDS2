package Atividades.arvores;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class ABB<K,V> implements IMapeamento<K,V> {
    private No<K,V> raiz;
    private Comparator<K> comparadorK;

    public ABB(Comparator<K> comparadorK, Comparator<V> comparadorV) {
        raiz = null;
        this.comparadorK = comparadorK;
    }

    @Override
    public void inserir(K chave, V valor) {
        this.raiz = inserir(chave, valor, raiz);
    }

    private No<K,V> inserir(K chave, V valor, No<K,V> raizArvore) {

        if (raizArvore==null) {
            raizArvore = new No<K,V>(chave, valor);
        }

        int comparacao = comparadorK.compare(chave, raizArvore.getChave());

        if (comparacao==0) {
            throw new RuntimeException("O item ja esta aramazenado na arvore!");
        }
        else if (comparacao<0) {
            raizArvore.setEsquerda(inserir(chave, valor, raizArvore.getEsquerda()));
        }
        else {
            raizArvore.setDireita(inserir(chave, valor, raizArvore.getDireita()));
        }

        return raizArvore;
    }

    @Override
    public V remover(K chave) {
        remover(chave, raiz);

        return pesquisar(chave);
    }

    private No<K,V> remover(K chave, No<K,V> raizArvore) {
        if (raizArvore==null) {
            throw new RuntimeException("O item nao foi encontrado");
        }

        int comparacao = comparadorK.compare(chave, raizArvore.getChave());

        if (comparacao==0) {
            if (raizArvore.getEsquerda()==null) {
                raizArvore = raizArvore.getDireita();
            }
            else if (raizArvore.getDireita()==null) {
                raizArvore = raizArvore.getEsquerda();
            }
            else {
                raizArvore.setEsquerda(removerNoAntecessor(raizArvore.getEsquerda(), raizArvore));
            }
        }
        else if (comparacao<0) {
            raizArvore.setEsquerda(remover(chave, raizArvore.getEsquerda()));
        }
        else {
            raizArvore.setDireita(remover(chave, raizArvore.getDireita()));
        }

        return raizArvore;
    }

    public No<K, V> removerNoAntecessor(No<K,V> raizArvore, No<K,V> novaRaiz) { 
        //antecessor = maior chave da esquerda
        //raizArvore: é a subárvore da esquerda do nó que você quer remover (o candidato a encontrar o antecessor).
        //novaRaiz: é o nó que você está realmente removendo da árvore, e mudando seus valores.
        if (raizArvore.getDireita()!=null) {
            raizArvore.setDireita(removerNoAntecessor(raizArvore.getDireita(), novaRaiz));
        }
        novaRaiz.setChave(raizArvore.getChave()); //remocao
        novaRaiz.setValor(raizArvore.getValor()); //remocao
        raizArvore = raizArvore.getEsquerda(); //atualiza o antigo antecessor caso ele tivesse filhos a esquerda
        return raizArvore;
    }

    @Override
    public V pesquisar(K chave) {
        return pesquisar(raiz, chave);
    }

    private V pesquisar (No<K,V> raizArvore, K chave) {
        if (raizArvore==null) {
            throw new NoSuchElementException("O item não foi localizado na árvore!");
        }
        int comparacao = comparadorK.compare(chave, raizArvore.getChave());

        if (comparacao==0) {
            return raizArvore.getValor();
        }
        else if (comparacao<0) {
            return pesquisar(raizArvore.getEsquerda(), chave);
        }
        else {
            return pesquisar(raizArvore.getDireita(), chave);
        }
    }

    //verifica se seus nos possuem exatamente 0 ou 2 filhos.
    public boolean verificarEstrita() {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vazia ou nula");
        }

        return verificarEstritaRec(this.raiz);
    }

    private boolean verificarEstritaRec(No<K,V> raizArvore) {
        if (raizArvore==null) {
            return true;
        }

        if ((raizArvore.getEsquerda()==null && raizArvore.getDireita()==null) || (raizArvore.getEsquerda()!=null && raizArvore.getDireita()!=null)) {
            return verificarEstritaRec(raizArvore.getEsquerda()) && verificarEstritaRec(raizArvore.getDireita());
        }

        return false;
    }

    public String caminhamentoPreOrdem() {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vazia");
        }
        return caminhamentoPreOrdemRec(raiz);
    }

    private String caminhamentoPreOrdemRec(No<K,V> raizArvore) {
        if (raizArvore==null) {
            return "";
        }
        return raizArvore.getValor().toString() + (caminhamentoPreOrdemRec(raizArvore.getEsquerda()) + caminhamentoPreOrdemRec(raizArvore.getDireita()));
    }

    public String caminhamentoPosOrdem() {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vazia");
        }
        return caminhamentoPosOrdemRec(this.raiz); 
    }

    private String caminhamentoPosOrdemRec(No<K,V> raizArvore) {
        if (raizArvore==null) {
            return "";
        }
        return caminhamentoPosOrdemRec(raizArvore.getEsquerda()) + caminhamentoPosOrdemRec(raizArvore.getDireita()) + raizArvore.getValor().toString() ;
    }

    public String caminhamentoDecrescente() {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vaiza!");
        }
        return caminhamentoDecrescenteRec(this.raiz);
    }

    private String caminhamentoDecrescenteRec(No<K,V> raizArvore) {
        if (raizArvore==null) {
            return "";
        }
        return caminhamentoDecrescenteRec(raizArvore.getDireita()) + raizArvore.getValor().toString() + caminhamentoDecrescenteRec(raizArvore.getEsquerda());
    }

    public V obterMenor() {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vaiza!");
        }
        return obterMenorRec(this.raiz);
    }

    private V obterMenorRec(No<K,V> raizArvore) {
        if (raizArvore.getEsquerda()==null) {
            return raizArvore.getValor();
        }
        return obterMenorRec(raizArvore.getEsquerda());
    }

    public int obterNivel(K chave) {
        if (this.raiz==null) {
            throw new NoSuchElementException("A arvore esta vaiza!");
        }
        return obterNivelRec(chave, this.raiz);
    }

    private int obterNivelRec(K chave, No<K,V> raizArvore) {
        int comparacao = comparadorK.compare(chave, raizArvore.getChave());
        if (comparacao>0){
            return 1+ obterNivelRec(chave, raizArvore.getDireita());
        }
        else if (comparacao<0) {
            return 1 + obterNivelRec(chave, raizArvore.getEsquerda());
        }
        return 0;
    }

    public No<K,V> obterNoSucessor(No<K,V> raizArvore) {
        if (raizArvore==null) {
            throw new NoSuchElementException("Raiz nao identificada!");
        }
        return obterNoSucessorRec(raizArvore.getDireita());
    }

    private No<K,V> obterNoSucessorRec(No<K,V> raizArvore) {
        if (raizArvore==null) {
            throw new NoSuchElementException("O No nao tem sucessor!");
        }
        if (raizArvore.getEsquerda()!=null) {
            return obterNoSucessorRec(raizArvore.getEsquerda());
        }
        return raizArvore;
    }
}