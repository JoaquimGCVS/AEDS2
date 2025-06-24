package Atividades.livrariaExercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Livraria {
    static final int LIMITE_DE_LIVROS = 10;
    static Livro[] livrosCadastrados = new Livro[LIMITE_DE_LIVROS];
    static Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

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
    static Livro criarLivro(String linhaDeDados) {
        String[] dados = linhaDeDados.split(";");
        int tipo = Integer.parseInt(dados[0]);
        String titulo = dados[1];
        String autor = dados[2];
        double preco = Double.parseDouble(dados[3]);

        if (tipo == 1) {
            double tamanhoArquivo = Double.parseDouble(dados[4]);
            return new LivroEbook(titulo, autor, preco, tamanhoArquivo);
        } else if (tipo == 2) {
            double peso = Double.parseDouble(dados[4]);
            return new LivroFisico(titulo, autor, preco, peso);
        } else {
            throw new IllegalArgumentException("Tipo de livro invalido");
        }
    }

    // 2- Criar um metodo que chama o metodo 1 para formar um arquivo csv
    static Livro[] lerLivros(String caminhoDoCSV) {
        Livro[] livros = new Livro[LIMITE_DE_LIVROS];
        Scanner arquivoCSV = null;
        try {
            arquivoCSV = new Scanner(new File(caminhoDoCSV), StandardCharsets.UTF_8);
            int quantidade = Integer.parseInt(arquivoCSV.nextLine());
            for (int i = 0; i < quantidade; i++) {
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

    static void salvarLivros(String caminhoDoCSV) {
        FileWriter arquivoDeSaida = null;
        int quantidade=0;
        try {
            arquivoDeSaida = new FileWriter(caminhoDoCSV,StandardCharsets.UTF_8);
        for (Livro livro : livrosCadastrados) {
            if(livro!=null) {
                quantidade++;
            }
        }
        arquivoDeSaida.append(quantidade + "\n");
        for (Livro livro : livrosCadastrados) {
            arquivoDeSaida.append(livro.linhaDeDados());
        } 
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    // 4- Criar um metodo para cadastrar um livro usando os metodos 1 e 2.
    static void cadastrarLivro() {
        int index = -1;
        for (int i = 0; i < livrosCadastrados.length; i++) {
            if (livrosCadastrados[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Não é possível cadastrar mais livros. Limite atingido.");
            return;
        }

        System.out.print("Digite o tipo do livro (1 - Físico, 2 - Ebook): ");
        int tipo = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine().trim();

        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine().trim();

        System.out.print("Digite o preço do livro: ");
        double preco = Double.parseDouble(sc.nextLine().trim());

        Livro novoLivro = null;

        if (tipo == 1) {
            System.out.print("Digite o tamanho do arquivo do ebook: ");
            double tamanhoArquivo = Double.parseDouble(sc.nextLine().trim());
            novoLivro = new LivroEbook(titulo, autor, preco, tamanhoArquivo);
        } else if (tipo == 2) {
            System.out.print("Digite o peso do livro: ");
            double peso = Double.parseDouble(sc.nextLine().trim());
            novoLivro = new LivroFisico(titulo, autor, preco, peso);
        } else {
            System.out.println("Tipo de livro inválido.");
            return;
        }

        livrosCadastrados[index] = novoLivro;
        System.out.println("Livro cadastrado com sucesso.");
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
                System.out.println("Livro removido com sucesso.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }
}