package Ordenacao;

public class BubbleSort {
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
        bubbleSort(array);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    static int[] bubbleSort(int[] array) {
        
        for (int i=array.length-1; i>0;i--) {
            for(int j=0;j< i;j++) {
                if(array[j]>array[j+1]) {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        
        return array;
    }

    //Bubble Sort: Compara elementos adjacentes(lado a lado) e os troca se estiverem fora de ordem, 
    //repetindo até que toda a lista esteja ordenada. Também é lento para listas grandes.
}
