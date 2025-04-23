package vetor.ordenandoVetor;

public class Ordenando {
    public static void main (String args[]) {

    }

    static int[] ordenaVetor(int[] vetor) {
        for (int referencia=0; referencia < vetor.length-1; referencia++) {
            int posicaoMenorValor = referencia;
            for (int posicaoNumeroComparado = referencia+1 ; posicaoNumeroComparado<vetor.length; posicaoNumeroComparado++) {
                if(vetor[posicaoMenorValor]>vetor[posicaoNumeroComparado]) {
                    posicaoMenorValor=posicaoNumeroComparado;
                }
            }
            int varivelTemporaria = vetor[referencia];
            vetor[referencia]=vetor[posicaoMenorValor];
            vetor[posicaoMenorValor]=varivelTemporaria;
        }
        return vetor;
    }
}
