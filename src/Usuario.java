// Classe que representa um usuário do sistema (administrador, gerente ou colaborador)

public class Usuario {
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String cargo;
    private String login;
    private String senha;
    private String perfil;

    public Usuario(String nomeCompleto, String cpf, String email, String cargo, String login, String senha, String perfil) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Getters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getPerfil() {
        return perfil;
    }

    // Exibição do usuário
    @Override
    public String toString() {
        return "Nome: " + nomeCompleto + " | CPF: " + cpf + " | Email: " + email +
                " | Cargo: " + cargo + " | Perfil: " + perfil;
    }
}