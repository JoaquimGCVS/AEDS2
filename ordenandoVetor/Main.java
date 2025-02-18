package ordenandoVetor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {64, 15, 12, 22, 11};

        for (int i = 0; i < vetor.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[index]) {
                    index = j; // Armazena o enderco do numero que eh menor que o index comparado
                }
            }
            // Troca os elementos
            int temp = vetor[i];
            vetor[i] = vetor[index]; // aqui ja com o endereco do menor
            vetor[index] = temp;
        }

        // Vetor ordenado
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
    }
}

