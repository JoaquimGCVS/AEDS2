public class App {
    public static void main(String[] args) {
        int[] array = {7,5,1,8,3};
        int n = array.length;

        System.out.println();
        System.out.print("Array inicial: ");
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Ordenado: " );
        insertionSort(array, n);
        for (int integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    static int[] selectionSort(int[] array, int n) {
        for (int i=0;i<n-1;i++) {
            int minimo = i;
            for (int j=i+1; j<n;j++) {
                if (array[j]<array[minimo]) {
                    minimo = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimo];
            array[minimo] = temp;
        }
        
        return array;
    }

    static int[] bubbleSort(int[] array, int n) {
        for (int i=0;i<n-1;i++) {
            for (int j=0; j<n-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        
        return array;
    }

    static int[] insertionSort(int[] array, int n) {
        for (int i=1;i<n;i++) {
            int modelo = array[i]; // valor a ser comparado
            int j = i-1; // valor de tras
            while (j>=0 && array[j]>modelo) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1]=modelo; // o j sempre estara 1 posicao antes da que desejamos alocar o valor modelo
        }
        
        return array;
    }

    static int[] mergeSort(int[] array, int n) {
         return array;
    }
}
