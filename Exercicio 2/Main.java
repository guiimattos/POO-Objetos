import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n MENU");
            System.out.println("1 - Criar Pessoa");
            System.out.println("2 - Criar Automóvel");
            System.out.println("3 - Transferir Automóvel");
            System.out.println("4 - Mostrar Todas as Pessoas");
            System.out.println("5 - Mostrar automóvel da pessoa");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código da pessoa: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome da pessoa: ");
                    String nome = sc.nextLine();

                    Pessoa pessoa = new Pessoa(codigo, nome);
                    pessoas.add(pessoa);
                    System.out.println("Pessoa criada com sucesso!");
                    break;

                case 2:
                    if (pessoas.isEmpty()) {
                        System.out.println("Cadastre uma pessoa antes de criar um automóvel.");
                        break;
                    }

                    System.out.print("Marca do automóvel: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo do automóvel: ");
                    String modelo = sc.nextLine();

                    System.out.println("Pessoas:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println(i + " - " + pessoas.get(i).imprimir());
                    }
                    System.out.print("Escolha o dono do automóvel: ");
                    int posDono = sc.nextInt();
                    sc.nextLine();

                    if (posDono < 0 || posDono >= pessoas.size()) {
                        System.out.println("Pessoa inválida!");
                    } else {
                        Automovel automovel = new Automovel(marca, modelo);
                        pessoas.get(posDono).inserirAutomovel(automovel);
                        System.out.println("Automóvel cadastrado para " + pessoas.get(posDono).getNome() + "!");
                    }
                    break;

                case 3:
                    if (pessoas.size() < 2) {
                        System.out.println("É preciso ter pelo menos 2 pessoas cadastradas para transferir.");
                        break;
                    }

                    System.out.println("Pessoas:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println(i + " - " + pessoas.get(i).imprimir());
                    }
                    System.out.print("Escolha a pessoa de origem: ");
                    int posOrigem = sc.nextInt();
                    sc.nextLine();

                    if (posOrigem < 0 || posOrigem >= pessoas.size()) {
                        System.out.println("Pessoa inválida!");
                        break;
                    }

                    Pessoa origem = pessoas.get(posOrigem);
                    if (origem.getAutomoveis().isEmpty()) {
                        System.out.println("Essa pessoa não possui automóveis para transferir.");
                        break;
                    }

                    System.out.println(origem.imprimirCompleto());
                    System.out.print("Escolha o automóvel: ");
                    int posAutomovel = sc.nextInt();
                    sc.nextLine();

                    if (posAutomovel < 0 || posAutomovel >= origem.getAutomoveis().size()) {
                        System.out.println("Automóvel inválido!");
                        break;
                    }

                    System.out.println("Pessoas:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println(i + " - " + pessoas.get(i).imprimir());
                    }
                    System.out.print("Escolha a pessoa de destino: ");
                    int posDestino = sc.nextInt();
                    sc.nextLine();

                    if (posDestino < 0 || posDestino >= pessoas.size()) {
                        System.out.println("Pessoa inválida!");
                        break;
                    }
                    if (posDestino == posOrigem) {
                        System.out.println("A pessoa de destino deve ser diferente da origem!");
                        break;
                    }

                    Automovel transferido = origem.getAutomoveis().get(posAutomovel);
                    origem.removerAutomovel(posAutomovel);
                    pessoas.get(posDestino).inserirAutomovel(transferido);
                    System.out.println("Automóvel transferido de " + origem.getNome()
                            + " para " + pessoas.get(posDestino).getNome() + "!");
                    break;

                case 4:
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        System.out.println("Pessoas cadastradas:");
                        for (int i = 0; i < pessoas.size(); i++) {
                            System.out.println(i + " - " + pessoas.get(i).imprimir());
                        }
                    }
                    break;

                case 5:
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                        break;
                    }

                    System.out.println("Pessoas:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println(i + " - " + pessoas.get(i).imprimir());
                    }
                    System.out.print("Escolha a pessoa: ");
                    int posPessoa = sc.nextInt();
                    sc.nextLine();

                    if (posPessoa < 0 || posPessoa >= pessoas.size()) {
                        System.out.println("Pessoa inválida!");
                    } else {
                        System.out.println(pessoas.get(posPessoa).imprimirCompleto());
                    }
                    break;

                case 6:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
