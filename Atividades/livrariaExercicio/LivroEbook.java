package Atividades.livrariaExercicio;

public class LivroEbook extends Livro {
    private double tamanhoArquivo;

    public LivroEbook(String titulo, String autor, double preco, double tamanhoArquivo) {
        super(titulo, autor, preco);
        setTamanhoArquivo(tamanhoArquivo);
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public String linhaDeDados() {
        return "1;" + super.getTitulo() + ";" + super.getAutor() + ";" + super.getPreco() + ";" + this.getTamanhoArquivo();
    }
}
