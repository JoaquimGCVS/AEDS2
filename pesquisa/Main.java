package pesquisa;

public class Main<T> {
    public static void main(String[] args) {
        int[] vetorOrdenado = {1,2,3,4,5,6};
        int[] vetorDesordenado = {3,2,4,1,5,6};

        System.out.println("Pesquisa sequencial:");
        System.out.println("Elemento encontrado na posicao " + pesquisaSequencial(vetorDesordenado, 5));
        System.out.println("Pesquisa binaria:");
        System.out.println("Elemento encontrado na posicao " + pesquisaBinaria(vetorOrdenado, 3, 0, 5));
    }

    //Complexidade O(n), ja que percorre todo o vetor e compara todos os valores ate encontrar a chave
    //Ineficiante para grandes vetores
    static int pesquisaSequencial(int[] vetor, int chave) {
        for (int i=0; i< vetor.length; i++) {
            if (vetor[i]==chave) {
                return i;
            }
        }
        return -1;
    }

    //Exige que o vetor esteja ordenado
    static int pesquisaBinaria(int[] vetor, int chave, int inicio, int fim) {
        if(inicio > fim) { 
            return -1;
        }

        int meio = (inicio + fim) /2;
        if (vetor[meio] == chave) { //Se o meio ja for o valor, retorna a posicao do meio
            return meio;
        }
        else if (chave < vetor[meio]) {
            return pesquisaBinaria(vetor, chave, inicio, meio-1); //Chave eh menor, meio se torna o fim, e -1 pois ja sabemos que meio nao eh a chave
        }
        else {
            return pesquisaBinaria(vetor, chave, meio+1, fim); //Chave eh maior, meio se torna o incio, e +1 pois ja sabemos que meio nao eh a chave
        }
    }   

    static <T> int pesquisaSequencialGenerica(T[] vetor, T chave) {
        for (int i=0; i<vetor.length; i++) {
            if (vetor[i].equals(chave)) {
                return i;
            }
        }
        return -1;
    }

    static <T extends Comparable<T>> int pesquisaBinariaGenerica(T[] vetor, T chave, int inicio, int fim) {
        int meio = (inicio + fim) / 2; 
        int comparacao = chave.compareTo(vetor[meio]); 
        if (comparacao==0) {
            return meio;
        }
        else if (comparacao<0) {
            return pesquisaBinariaGenerica(vetor, chave, inicio, meio-1);
        }
        else {
            return pesquisaBinariaGenerica(vetor, chave, meio+1, fim);
        }
    }
}
