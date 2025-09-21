import java.time.LocalDate;

// Classe que representa um projeto dentro do sistema

public class Projeto {
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFimPrevista;
    private String status;
    private Usuario gerente;

    public Projeto(String nome, String descricao, LocalDate dataInicio, LocalDate dataFimPrevista, String status, Usuario gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFimPrevista = dataFimPrevista;
        this.status = status;
        this.gerente = gerente;
    }

    // Exibição do projeto
    @Override
    public String toString() {
        return "Projeto: " + nome + " | Status: " + status + " | Gerente: " + gerente.getNomeCompleto();
    }
}