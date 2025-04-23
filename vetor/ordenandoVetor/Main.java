package vetor.ordenandoVetor;
public class Main {
    public static void main(String[] args) {

        int[] vetor = {14,4,112,34};
        int menor;
        for (int referencia=0;referencia<vetor.length-1;referencia++) {
            menor=referencia; 
            for (int i=referencia+1;i<vetor.length;i++) {
                if (vetor[i]<vetor[menor]) {
                    menor=i;
                }
            }
            int temp = vetor[referencia]; // aramazena temporariamente o valor do vetor[referencia] pois ele vai ser trocado e realocado
            vetor[referencia] = vetor[menor]; // joga o valor encontrado para vetor[menor] para a posicao atual de vetor[referencia]
            vetor[menor]=temp; // joga o valor antigo de vetor[referencia] para a posicao que o vetor[menor] estava
        }
        for (int i=0; i<vetor.length;i++) {
            System.out.println(vetor[i]);
        }
    }
}
