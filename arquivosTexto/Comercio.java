package arquivosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Comercio {
    /** Para inclusão de novos produtos no vetor */
    static final int MAX_NOVOS_PRODUTOS = 10;

    /** Nome do arquivo de dados. O arquivo deve estar localizado na raiz do projeto */
    static String nomeArquivoDados;
    
    /** Scanner para leitura do teclado */
    static Scanner teclado;

    /** Vetor de produtos cadastrados. Sempre terá espaço para 10 novos produtos a cada execução */
    static Produto[] produtosCadastrados;

    /** Quantidade produtos cadastrados atualmente no vetor */
    static int quantosProdutos;

    /** Gera um efeito de pausa na CLI. Espera por um enter para continuar */
    static void pausa(){
        System.out.println("Digite enter para continuar...");
        teclado.nextLine();
    }

    /** Cabeçalho principal da CLI do sistema */
    static void cabecalho(){
        System.out.println("AEDII COMÉRCIO DE COISINHAS");
        System.out.println("===========================");
    }

    /** Imprime o menu principal, lê a opção do usuário e a retorna (int).
     * Perceba que poderia haver uma melhor modularização com a criação de uma classe Menu.
     * @return Um inteiro com a opção do usuário.
    */
    static int menu(){
        cabecalho();
        System.out.println("1 - Listar todos os produtos");
        System.out.println("2 - Procurar e listar um produto");
        System.out.println("3 - Cadastrar novo produto");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        return Integer.parseInt(teclado.nextLine());
    }

    /**
     * Lê os dados de um arquivo texto e retorna um vetor de produtos. Arquivo no formato
     * N  (quantiade de produtos) <br/>
     * tipo; descrição;preçoDeCusto;margemDeLucro;[dataDeValidade] <br/>
     * Deve haver uma linha para cada um dos produtos. Retorna um vetor vazio em caso de problemas com o arquivo.
     * @param nomeArquivoDados Nome do arquivo de dados a ser aberto.
     * @return Um vetor com os produtos carregados, ou vazio em caso de problemas de leitura.
     */
    static Produto[] lerProdutos(String nomeArquivoDados) {
        Scanner arquivoEntrada = null;
        int qnt;
        String linha;
        Produto[] produtosCadastrados = new Produto[MAX_NOVOS_PRODUTOS];
        try {
            arquivoEntrada = new Scanner(new File(nomeArquivoDados), Charset.forName("UTF-8"));
            qnt = Integer.parseInt(arquivoEntrada.nextLine());
            for (int i = 0; i < qnt; i++) {
                if (arquivoEntrada.hasNextLine()) {
                    linha = arquivoEntrada.nextLine();
                    produtosCadastrados[i] = Produto.criarDoTexto(linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivoDados);
            return new Produto[0]; // Retorna um vetor vazio
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return new Produto[0];
        } finally {
            if (arquivoEntrada != null) {
                arquivoEntrada.close();
            }
        }
        return produtosCadastrados;
    }

    
    /** Localiza um produto no vetor de cadastrados, a partir do nome, e imprime seus dados. 
     *  A busca não é sensível ao caso.  Em caso de não encontrar o produto, imprime mensagem padrão */
    static void localizarProdutos() {
        System.out.print("Digite o nome do produto a ser localizado: ");
        String nomeProduto = teclado.nextLine().trim().toLowerCase();
        boolean encontrado = false;
    
        for (Produto produto : produtosCadastrados) {
            if (produto != null && produto.descricao.toLowerCase().contains(nomeProduto)) {
                System.out.println(produto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    

    /**
     * Salva os dados dos produtos cadastrados no arquivo csv informado. Sobrescreve todo o conteúdo do arquivo.
     * @param nomeArquivo Nome do arquivo a ser gravado.
     */
    public static void salvarProdutos(String nomeArquivo){
        try {
            FileWriter arquivoSaida = new FileWriter(nomeArquivo, Charset.forName("UTF-8"));
            arquivoSaida.append(quantosProdutos+"\n");
            for (int i = 0; i < produtosCadastrados.length; i++) {
                if(produtosCadastrados[i] != null)
                    arquivoSaida.append(produtosCadastrados[i].gerarDadosTexto()+"\n");
            }
            arquivoSaida.close();    
            System.out.println("Arquivo "+nomeArquivo+" salvo.");
        } catch (IOException e) {
            System.out.println("Problemas no arquivo "+nomeArquivo+". Tente novamente");
        }  
    }

    /** Lista todos os produtos cadastrados, numerados, um por linha */
    static void listarTodosOsProdutos() {
        int index=0;
        for (Produto produto : produtosCadastrados) {
            System.out.println(index++ + "- " + produto.toString());
        }
    }

    /**
    * Rotina para cadastro de um novo produto: pergunta ao usuário o tipo do produto, lê os dados correspondentes,
    * cria o objeto adequado de acordo com seu tipo, e inclui o produto no vetor.
    */
    /**
 * Rotina para cadastro de um novo produto: pergunta ao usuário o tipo do produto, lê os dados correspondentes,
 * cria o objeto adequado de acordo com seu tipo, e inclui o produto no vetor.
 */
static void cadastrarProduto() {
    if (quantosProdutos >= produtosCadastrados.length) {
        System.out.println("Não é possível cadastrar mais produtos. Limite atingido.");
        return;
    }

    System.out.print("Digite o tipo do produto (1 - Não Perecível, 2 - Perecível): ");
    int tipo = Integer.parseInt(teclado.nextLine().trim());

    System.out.print("Digite a descrição do produto: ");
    String descricao = teclado.nextLine().trim();

    System.out.print("Digite o preço de custo do produto: ");
    double precoCusto = Double.parseDouble(teclado.nextLine().trim());

    System.out.print("Digite a margem de lucro do produto: ");
    double margemLucro = Double.parseDouble(teclado.nextLine().trim());

    Produto novoProduto = null;

    if (tipo == 1) {
        novoProduto = new ProdutoNaoPerecivel(descricao, precoCusto, margemLucro);
    } else if (tipo == 2) {
        System.out.print("Digite a data de validade do produto (dd/MM/yyyy): ");
        String dataValidadeStr = teclado.nextLine().trim();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDeValidade = LocalDate.parse(dataValidadeStr, formato);
        novoProduto = new ProdutoPerecivel(descricao, precoCusto, margemLucro, dataDeValidade);
    } else {
        System.out.println("Tipo de produto inválido.");
        return;
    }

    produtosCadastrados[quantosProdutos++] = novoProduto;
    System.out.println("Produto cadastrado com sucesso.");
}  

    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in, Charset.forName("ISO-8859-2"));
        nomeArquivoDados = "dadosProdutos.csv";
        produtosCadastrados = lerProdutos(nomeArquivoDados);
        int opcao = -1;
        do{
            opcao = menu();
            switch (opcao) {
                case 1 -> listarTodosOsProdutos();
                case 2 -> localizarProdutos();
                case 3 -> cadastrarProduto();
            }
            pausa();
        }while(opcao !=0);       

        salvarProdutos(nomeArquivoDados);
        teclado.close();    
    }
}
