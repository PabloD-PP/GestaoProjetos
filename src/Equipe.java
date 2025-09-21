import java.util.ArrayList;
import java.util.List;

// Classe que representa uma equipe

public class Equipe {
    private String nome;
    private String descricao;
    private List<Usuario> membros = new ArrayList<>();

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Adicionar um usuário como membro da equipe
    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
    }

    // Exibição da equipe
    @Override
    public String toString() {
        return "Equipe: " + nome + " | Membros: " + membros.size();
    }
}