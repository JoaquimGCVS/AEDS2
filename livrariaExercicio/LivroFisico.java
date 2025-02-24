package livrariaExercicio;

public class LivroFisico extends Livro{
    private double peso;

    public LivroFisico(String titulo, String autor, double preco, double peso) {
        super(titulo, autor, preco);
        setPeso(peso);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String linhaDeDados() {
        return "2;" + super.getTitulo() + ";" + super.getAutor() + ";" + super.getPreco() + ";" + this.getPeso();
    }
}
