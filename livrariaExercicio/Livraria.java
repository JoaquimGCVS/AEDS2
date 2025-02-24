package livrariaExercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Livraria {
    static final int LIMITE_DE_LIVROS = 10;
    static final Livro[] livrosCadastrados = new Livro[LIMITE_DE_LIVROS];

    static Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8); // inicializa scanner para leitura do teclado e define seu conjunto de caracteres

    public static void main(String[] args) {
        String nomeArquivo = "livros.csv";
        livrosCadastrados = lerLivros(nomeArquivo);
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1 -> listarTodosOsLivros();
                case 2 -> localizarLivro();
                case 3 -> cadastrarLivro();
                case 4 -> removerLivro();
            }
        } while (opcao != 0);
        salvarLivros(nomeArquivo);
    }

    static int menu() {
        System.out.println("\n1 - Listar todos os livros");
        System.out.println("2 - Procurar e listar um livro");
        System.out.println("3 - Cadastrar novo livro");
        System.out.println("4 - Remover um livro");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    // 1- Criar metodo para ler os dados de uma linha e criar um tipo de livro
    // 2- Criar um metodo que le um arquivo csv, chama o metodo 1 para retornar um vetor de livros para serem cadastrados
    // 4- Criar um metodo para cadastrar um livro, e depois colocalos no vetor principal da classe usando os metodos 1 e 2.
    // 5- Criar um metodo para, ao final das acoes, salvar os livros cadastrados.

    static Livro criarLivro(String linhaDeDados) {
        String[] dados = linhaDeDados.split(";");
        int tipo = Integer.parseInt(dados[0]);
        String titulo = dados[1];
        String autor = dados[2];
        double preco = Double.parseDouble(dados[3]);

        if (tipo==1) {
            double tamanhoArquivo = Double.parseDouble(dados[4]);
            return new LivroEbook(titulo, autor, preco, tamanhoArquivo);
        }
        if (tipo==2) {
            double peso = Double.parseDouble(dados[4]);
            return new LivroEbook(titulo, autor, preco, peso);
        } else {
            throw new IllegalArgumentException("Tipo de livro invalido");
        }
    }

    static Livro[] lerLivros(String caminhoDoCSV) {
        Livro[] livros = new Livro[LIMITE_DE_LIVROS];
        Scanner arquivoCSV = null;
        try {
            arquivoCSV = new Scanner(new File(caminhoDoCSV),StandardCharsets.UTF_8 );
            int quantidade = Integer.parseInt(arquivoCSV.nextLine());
            for (int i=0;i<quantidade;i++) {
                livros[i] = criarLivro(arquivoCSV.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + caminhoDoCSV);
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (arquivoCSV != null) {
                arquivoCSV.close();
            }
        }
        return livros;
    }

    static void salvarLivros(String nomeArquivo) {
        try (FileWriter arquivoSaida = new FileWriter(nomeArquivo, StandardCharsets.UTF_8)) {
            arquivoSaida.append(quantosLivros + "\n");
            for (Livro livro : livrosCadastrados) {
                if (livro != null) {
                    arquivoSaida.append(livro.gerarDadosTexto() + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    // Métodos adicionais para listar, localizar e remover livros
    static void listarTodosOsLivros() {
        int index = 0;
        for (Livro livro : livrosCadastrados) {
            if (livro != null) {
                System.out.println(index++ + "- " + livro.toString());
            }
        }
    }

    static void localizarLivro() {
        System.out.print("Digite o título do livro a ser localizado: ");
        String titulo = sc.nextLine().trim().toLowerCase();
        boolean encontrado = false;

        for (Livro livro : livrosCadastrados) {
            if (livro != null && livro.getTitulo().toLowerCase().contains(titulo)) {
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    static void removerLivro() {
        System.out.print("Digite o título do livro a ser removido: ");
        String titulo = sc.nextLine().trim().toLowerCase();
        boolean encontrado = false;

        for (int i = 0; i < livrosCadastrados.length; i++) {
            if (livrosCadastrados[i] != null && livrosCadastrados[i].getTitulo().toLowerCase().contains(titulo)) {
                livrosCadastrados[i] = null;
                encontrado = true;
                quantosLivros--;
                System.out.println("Livro removido com sucesso.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

}
