package Recursividade;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int opcao;

        do {
            System.out.println("Qual operacao deseja executar? ");
            System.out.println("1--> Somar todos os numero pares ate um limite (n)");
            System.out.println("2--> Somar todos os elemento de um vetor de numeros double");
            System.out.println("3--> Contar a quantidade de repeticoes, em um vetor, de um numero (n)");
            System.out.println("4--> Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o limite: ");
                    int limite = sc.nextInt();
                    int somaPares = menu.somarPares(limite);
                    System.out.println("A soma de todos os números pares até " + limite + " é: " + somaPares);
                    break;
                case 2:
                    System.out.println("Digite o tamanho do vetor: ");
                    int tamanho = sc.nextInt();
                    double[] array = new double[tamanho];
                    System.out.println("Digite os elementos do vetor: ");
                    for (int i = 0; i < tamanho; i++) {
                        array[i] = sc.nextDouble();
                    }
                    double soma = menu.somarDouble(array, 0);
                    System.out.println("A soma de todos os elementos do vetor é: " + soma);
                    break;
                case 3:
                    System.out.println("Digite o tamanho do vetor: ");
                    int tamanhoVetor = sc.nextInt();
                    int[] vetor = new int[tamanhoVetor];
                    System.out.println("Digite os elementos do vetor: ");
                    for (int i = 0; i < tamanhoVetor; i++) {
                        vetor[i] = sc.nextInt();
                    }
                    System.out.println("Digite o número a ser contado: ");
                    int numero = sc.nextInt();
                    int repeticoes = menu.contarRepeticoes(vetor, 0, numero);
                    System.out.println("O número " + numero + " aparece " + repeticoes + " vezes no vetor.");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);

        sc.close();
    }

    public int somarPares(int limite) {
        if (limite <= 0) { // caso base
            return 0;
        }
        if (limite % 2 != 0) {
            return somarPares(limite - 1);
        }

        return limite + somarPares(limite - 2);
    }

    public double somarDouble(double[] array, int indice) {
        if (indice >= array.length) { // caso base
            return 0;
        }

        return array[indice] + somarDouble(array, indice + 1);
    }

    public int contarRepeticoes(int[] array, int indice, int numero) {
        if (indice >= array.length) { // caso base
            return 0;
        }
        if (array[indice] != numero) {
            return contarRepeticoes(array, indice + 1, numero);
        }

        return 1 + contarRepeticoes(array, indice + 1, numero);
    }

    public int somatorio(int n) {
        if (n==0) {
            return 0;
        }  
        else {
            return n + somatorio(n-1);
        }
    }
}