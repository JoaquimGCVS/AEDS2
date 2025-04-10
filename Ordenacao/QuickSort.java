package Ordenacao;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 2, 1, 3, 6, 5, 4 };
        System.out.println();
        System.out.print("Array desordenado: ");
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println();
        System.out.print("Array ordenado por quick: ");
        quickSort(array,0,array.length-1);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    static int[] quickSort(int[] array, int inicio, int fim) {
        if (inicio<fim) {
            int indexPivo = particionar(array, inicio, fim);
            quickSort(array, indexPivo+1, fim);
            quickSort(array, inicio, indexPivo-1 );
        }
        return array;
    }

    private static int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int part = inicio-1;
        for (int i=inicio; i <fim; i++) {
            if (array[i]<pivo) {
                part++;
                swap(array, part, i);
            }
        }
        return part + 1;
    }

    private static void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
