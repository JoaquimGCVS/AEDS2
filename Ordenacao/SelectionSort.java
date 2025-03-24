package Ordenacao;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = { 2, 1, 3, 6, 5, 4 };
        System.out.println();
        System.out.print("Array desordenado: ");
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println();
        System.out.print("Array ordenado por selecao: ");
        selectionSort(array);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();

    }

    static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            int temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }

        return array;
    }
}
