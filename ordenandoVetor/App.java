package ordenandoVetor;

public class App {
    public static void main(String[] args) {
        int[] vetor = { 23, 87, 92, 9, 3 };

        System.out.println();
        System.out.print("Before: ");
        for (int elemento : vetor) {
            System.out.print(elemento + " ");
        }

        vetor = organizarPorSelecao(vetor);
        System.out.println();

        System.out.print("After: ");
        for (int elemento : vetor) {
            System.out.print(elemento + " ");
        }
    }

    static int[] organizarPorSelecao(int[] vetor) {
        for (int referencia = 0; referencia < vetor.length - 1; referencia++) {
            int menor = referencia;
            for (int i = referencia + 1; i < vetor.length; i++) {
                if (vetor[menor] > vetor[i]) {
                    menor = i;
                }
            }
            int temp = vetor[referencia];
            vetor[referencia] = vetor[menor];
            vetor[menor] = temp;
        }

        return vetor;
    }
}
