package Ordenacao;

public class HeapSort {
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
        heapSort(array);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    static int[] heapSort(int[] array) {
        
    }
}
