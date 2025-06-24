package Atividades.arvores;

public interface IMapeamento<K, V> {
    public void inserir(K chave, V valor);
    public V pesquisar(K chave);
    public V remover(K chave);
}
