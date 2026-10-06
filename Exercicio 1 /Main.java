import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Curso> cursos = new ArrayList<>();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Criar Aluno");
            System.out.println("3 - Remover Aluno");
            System.out.println("4 - Mostrar Todos os Cursos");
            System.out.println("5 - Mostrar alunos do curso");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código do curso: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do curso: ");
                    String nomeCurso = sc.nextLine();
                    System.out.print("Carga horária: ");
                    int cargaHoraria = sc.nextInt();
                    sc.nextLine();

                    Curso curso = new Curso(codigo, nomeCurso, cargaHoraria);
                    cursos.add(curso);
                    System.out.println("Curso criado com sucesso!");
                    break;

                case 2:
                    if (cursos.isEmpty()) {
                        System.out.println("Cadastre um curso antes de criar um aluno.");
                        break;
                    }

                    System.out.print("RA do aluno: ");
                    String ra = sc.nextLine();
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = sc.nextLine();

                    System.out.println("Cursos disponíveis:");
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.println(i + " - " + cursos.get(i).imprimir());
                    }
                    System.out.print("Escolha o curso do aluno: ");
                    int posCurso = sc.nextInt();
                    sc.nextLine();

                    if (posCurso < 0 || posCurso >= cursos.size()) {
                        System.out.println("Curso inválido!");
                    } else {
                        Aluno aluno = new Aluno(ra, nomeAluno);
                        cursos.get(posCurso).inserirAluno(aluno);
                        System.out.println("Aluno cadastrado no curso " + cursos.get(posCurso).getNome() + "!");
                    }
                    break;

                case 3:
                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                        break;
                    }

                    System.out.println("Cursos:");
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.println(i + " - " + cursos.get(i).imprimir());
                    }
                    System.out.print("Escolha o curso: ");
                    int posCursoRemover = sc.nextInt();
                    sc.nextLine();

                    if (posCursoRemover < 0 || posCursoRemover >= cursos.size()) {
                        System.out.println("Curso inválido!");
                        break;
                    }

                    Curso cursoEscolhido = cursos.get(posCursoRemover);
                    if (cursoEscolhido.getAlunos().isEmpty()) {
                        System.out.println("Esse curso não tem alunos.");
                        break;
                    }

                    System.out.println(cursoEscolhido.imprimirCompleto());
                    System.out.print("Escolha o aluno que deseja remover: ");
                    int posAluno = sc.nextInt();
                    sc.nextLine();

                    if (posAluno < 0 || posAluno >= cursoEscolhido.getAlunos().size()) {
                        System.out.println("Aluno inválido!");
                    } else {
                        cursoEscolhido.removerAluno(posAluno);
                        System.out.println("Aluno removido com sucesso!");
                    }
                    break;

                case 4:
                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {
                        System.out.println("Cursos cadastrados:");
                        for (int i = 0; i < cursos.size(); i++) {
                            System.out.println(i + " - " + cursos.get(i).imprimir());
                        }
                    }
                    break;

                case 5:
                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                        break;
                    }

                    System.out.println("Cursos:");
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.println(i + " - " + cursos.get(i).imprimir());
                    }
                    System.out.print("Escolha o curso: ");
                    int posCursoMostrar = sc.nextInt();
                    sc.nextLine();

                    if (posCursoMostrar < 0 || posCursoMostrar >= cursos.size()) {
                        System.out.println("Curso inválido!");
                    } else {
                        System.out.println(cursos.get(posCursoMostrar).imprimirCompleto());
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
