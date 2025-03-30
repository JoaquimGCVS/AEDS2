package AtvApoio;

public class AtividadeApp {
    
    public static void main (String[] args) {
        int[] array = {1,2,3,4};
        inversoRecursivo(array,4);
        System.out.println();
        String palavra = "Anna";
        System.out.println("Vogais: " + vogaisRecusivo(palavra, 4));
        System.out.println();
        System.out.println(palindromoRecursivo(palavra, 4, 0));
        System.out.println();
        int[] maxMin = maiorMenor(array);
        for (int inteiro : maxMin) {
            System.out.print(inteiro + " ");
        }
        System.out.println();
        System.out.println();
    }
    
    //Implemente um método recursivo, em Java, que receba como parâmetro um vetor A, de
    //inteiros, e imprima os valores dos elementos armazenados nesse vetor, de trás para
    //frente.
    private static void inversoRecursivo(int[] array, int n) {
        if (n==0) {
            return;
        }
        else {
            System.out.println(array[n-1]);
            inversoRecursivo(array, n-1);
        }
    }

    // Implemente um método recursivo, em Java, que receba como parâmetro uma String e
    // retorne um número inteiro indicando a quantidade de vogais que a String apresenta.
    private static int vogaisRecusivo(String palavra, int tamanho) {
        if (tamanho==0) {
            return 0;
        }
        palavra = palavra.toUpperCase(); 
        char letra = palavra.charAt(tamanho - 1);
        int cont = (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') ? 1 : 0;
        return cont + vogaisRecusivo(palavra, tamanho-1);
    }

    // Implemente um método recursivo, em Java, que receba como parâmetro uma String e
    // retorne um valor booleano indicando se essa String de entrada é um palíndromo.
    private static Boolean palindromoRecursivo(String palavra, int tamanho, int index) {
        if (tamanho == 0 || tamanho == 1 || tamanho<=index) {
            return true;
        }
        palavra = palavra.toLowerCase();
        char letra1 = palavra.charAt(tamanho-1);
        char letra2 = palavra.charAt(index);

        if (letra1!=letra2) {
            return false;
        }
        return palindromoRecursivo(palavra, tamanho-1, index+1);
    } 

    // Implemente um método, em Java, que receba como parâmetro um número inteiro “n” e
    // efetue subtrações de forma que a função de complexidade desse método, em relação ao
    // número de subtrações, seja 3n + 2n^2

    static void subtracoesComplexidade(int n) {
        int a=10;
        int b=10;
        int c=10;
        for (int i=0;i<n;i++) {
            a--;
            b--;
            c--;
        }

        for (int j=0;j<n;j++) {
            for (int k=0;k<n;k++) {
                a--;
                b--;
            }
        }
    }

    // Implemente uma função, em Java, que seja capaz de encontrar o maior e o menor
    // elementos de um array, utilizando a seguinte estratégia de comparação:
    // • Comparar os elementos do vetor aos pares, separando-os em dois subconjuntos.
    // • O máximo é obtido do subconjunto que contém os maiores elementos e o
    // mínimo é obtido do subconjunto que contém os menores elementos.
    // Sua função deve receber como parâmetro um vetor A de inteiros e retornar um vetor
    // com apenas 2 elementos: o maior e o menor.  

    static int[] maiorMenor(int[] array) {
       int maior = array[0];
       int menor = array[0]; 

       for (int i=0;i<array.length-1;i+=2) {
        int a = array[i];
        int b = array[i+1];

        if (a>=b) {
            maior = Math.max(a, maior);
            menor = Math.min(b, menor);
        } else {
            maior = Math.max(b, maior);
            menor = Math.min(a, menor);
        }
       }

       if (array.length%2 != 0) {
        maior = Math.max(maior, array[array.length-1]);
        menor = Math.min(menor, array[array.length-1]);
       }
        
        return new int[] {maior, menor};
    }
}
