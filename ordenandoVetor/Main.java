package ordenandoVetor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] vetor = { 212, 32, 122 };
        int menor = vetor[0];
        int temp = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int f = 1; f < vetor.length; f++) {
                if (vetor[f] < menor) {
                    menor = vetor[f];
                }
            }
            temp = vetor[i];
            vetor[i] = menor;
           
        }
        System.out.println(Arrays.toString(vetor));
    }
}
