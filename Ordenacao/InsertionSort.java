package Ordenacao;

public class InsertionSort {
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
        insertionSort(array);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    static int[] insertionSort(int[] array) {
        for (int i=1;i<array.length;i++) {
            int temp = array[i];
            int j=i-1;
            while (j>=0 && array[j]>temp) {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
        return array;
    }

    // Insertion Sort: Insere cada elemento na posição correta, movendo os elementos maiores para a direita.
    // É eficiente para listas pequenas ou quase ordenadas.
}
