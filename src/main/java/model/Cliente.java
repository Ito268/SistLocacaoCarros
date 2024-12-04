package model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;

    // Construtor
    public Cliente(int idCliente, String nome, String cpf, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Cliente [ID=" + idCliente + ", Nome=" + nome + ", CPF=" + cpf + ", Telefone=" + telefone + "]";
    }
}

