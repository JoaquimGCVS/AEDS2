package estruturaDinamica.Lista;

public class Lista<T> {
    private Celula<T> primeiro;
    private Celula<T> ultimo;

    public Lista () {
        Celula<T> sentinela = new Celula<T>();
        primeiro = ultimo = sentinela;
    }

    public void inserir(T item) {
        Celula<T> novaCelula = new Celula<T>(item, null);
        ultimo.setProximaCelula(novaCelula);
        ultimo = novaCelula;
    }
}
