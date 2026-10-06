import java.util.ArrayList;

public class Pessoa {

    private int codigo;
    private String nome;
    private ArrayList<Automovel> automoveis;

    public Pessoa() {
        automoveis = new ArrayList<>();
    }

    public Pessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        automoveis = new ArrayList<>();
    }

    public void inserirAutomovel(Automovel automovel) {
        automoveis.add(automovel);
    }

    public void removerAutomovel(int index) {
        automoveis.remove(index);
    }


    public String imprimir() {
        return "Código: " + codigo + " | Nome: " + nome + " | Qtd. de automóveis: " + automoveis.size();
    }


    public String imprimirCompleto() {
        String texto = imprimir() + "\nAutomóveis:";

        if (automoveis.isEmpty()) {
            texto += "\n  Essa pessoa não possui automóveis.";
        } else {
            for (int i = 0; i < automoveis.size(); i++) {
                texto += "\n  " + i + " - " + automoveis.get(i).imprimir();
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

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(ArrayList<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
}
