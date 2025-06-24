package Atividades.Ordenacao.SubstituirLetras;

public class App {

// Substitua XXXXXXXX pelas 8 primeiras letras de seu nome, desprezando brancos e
// letras repetidas, para resolver esta questão. Se você não tiver 8 letras diferentes
// em seu nome, complete com as letras TUVWXYZ, nessa ordem.
// Ordene a expressão formada acima utilizando cada um dos métodos de
// ordenação citados abaixo. Mostre cada uma das etapas de funcionamento de cada
// um desses métodos de ordenação:
// a) Bolha 
// b) Seleção
// c) Inserção
// d) Mergesort
// e) Heapsort
// f) Quicksort

    public static void main (String[] args) {
        String nome = "JOAQUIM";
        System.out.println();
        System.out.println("Ordenando com:");
        System.out.print("BubbleSort: " + bubbleSort(nome));
        System.out.println();
        System.out.print("SelectionSort: " + bubbleSort(nome));
        System.out.println();
        System.out.print("InsertionSort: " + bubbleSort(nome));
        System.out.println();
        System.out.print("MergeSort: " + bubbleSort(nome));
        System.out.println();
        System.out.print("HeapSort: " + bubbleSort(nome));
        System.out.println();
        System.out.print("QuickSort: " + bubbleSort(nome));
        System.out.println();
    }

    static String bubbleSort(String nome) {
        char[] letras = nome.toCharArray(); // Converte a string em um array de caracteres
        int n = letras.length;
    
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (letras[j] > letras[j + 1]) {
                    // Troca os caracteres se estiverem fora de ordem
                    char temp = letras[j];
                    letras[j] = letras[j + 1];
                    letras[j + 1] = temp;
                }
            }
        }
    
        return new String(letras); // Converte o array de volta para string
    }
}
