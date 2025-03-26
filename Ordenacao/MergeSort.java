package Ordenacao;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 2, 1, 3, 6, 5, 4 };
        System.out.println();
        System.out.print("Array desordenado: ");
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println();
        System.out.print("Array ordenado por insercao: ");
        mergeSort(array);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    static int[] mergeSort(int[] array) {
        return array;
    }

    // Merge Sort: Divide o array em duas metades, ordena cada metade recursivamente e, 
    // em seguida, combina as duas metades ordenadas para produzir o array final ordenado.
    // É eficiente para listas grandes e tem complexidade de tempo O(n log n).
}
