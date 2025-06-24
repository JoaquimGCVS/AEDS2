package Atividades.pesquisa;

public class App {

    static <T> int pesquisaSequencial(T[] vetor, T chave) {
        for (int i=0; i<vetor.length; i++) {
            if (vetor[i].equals(chave)) {
                return i;
            }
        }
        return -1;
    }

    static <T extends Comparable<T>> int pesquisaBinaria(T[] vetor, T chave, int inicio, int fim) {
        if (fim<inicio) {
            return -1;
        }

        int meio = (inicio+fim)/2;
        int comparacao = chave.compareTo(vetor[meio]);

        if (vetor[meio].equals(chave) && comparacao==0) {
            return meio;
        }
        else if (comparacao<0) {
            return pesquisaBinaria(vetor, chave, inicio, meio-1);
        }
        else {
            return pesquisaBinaria(vetor, chave, meio+1, fim);
        }
    }
}




