import java.util.ArrayList;

public class Curso {

    private int codigo;
    private String nome;
    private int cargaHoraria;
    private ArrayList<Aluno> alunos;

    public Curso() {
        alunos = new ArrayList<>();
    }

    public Curso(int codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        alunos = new ArrayList<>();
    }

    public void inserirAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int index) {
        alunos.remove(index);
    }

    public String imprimir() {
        return "Código: " + codigo + " | Nome: " + nome + " | Carga Horária: " + cargaHoraria + "h";
    }

    public String imprimirCompleto() {
        String texto = imprimir() + "\nAlunos:";

        if (alunos.isEmpty()) {
            texto += "\n  Nenhum aluno cadastrado neste curso.";
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                texto += "\n  " + i + " - " + alunos.get(i).imprimir();
            }
        }

        return texto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
}
