package com.mycompany.sistemalocacaocarros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroCliente extends JFrame {

    private JTextField txtNome, txtTelefone, txtCpf, txtIdade, txtEmail;
    private JButton btnCadastrar;
    private List<Cliente> listaClientes;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 400); // Aumentei o tamanho para incluir o campo de email
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da interface
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblTelefone = new JLabel("Telefone:");
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblIdade = new JLabel("Idade:");
        JLabel lblEmail = new JLabel("Email:");

        txtNome = new JTextField(15);
        txtTelefone = new JTextField(15);
        txtCpf = new JTextField(15);
        txtIdade = new JTextField(15);
        txtEmail = new JTextField(15);

        btnCadastrar = new JButton("Cadastrar");

        // Posicionando os componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNome, gbc);
        gbc.gridx = 1;
        add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblTelefone, gbc);
        gbc.gridx = 1;
        add(txtTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblCpf, gbc);
        gbc.gridx = 1;
        add(txtCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblIdade, gbc);
        gbc.gridx = 1;
        add(txtIdade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblEmail, gbc);
        gbc.gridx = 1;
        add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(btnCadastrar, gbc);

        // Inicializar lista de clientes
        listaClientes = new ArrayList<>();

        // Evento do botão de cadastro
        btnCadastrar.addActionListener(this::cadastrarCliente);

        setVisible(true);
    }

    private void cadastrarCliente(ActionEvent e) {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String cpf = txtCpf.getText();
        String idadeText = txtIdade.getText();
        String email = txtEmail.getText();

        if (nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty() || idadeText.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificação simples do CPF (11 dígitos)
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "CPF inválido! Deve ter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificação simples da idade (apenas números positivos)
        int idade;
        try {
            idade = Integer.parseInt(idadeText);
            if (idade <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade inválida! Deve ser um número positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificação simples do email
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Email inválido! O email deve conter '@'.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Gerando ID automaticamente
        int id = listaClientes.size() + 1;

        // Cadastra o novo cliente
        Cliente novoCliente = new Cliente(id, nome, telefone, cpf, idade, email);
        listaClientes.add(novoCliente);

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Limpar campos
        txtNome.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
        txtIdade.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) {
        new TelaCadastroCliente();
    }
}

// Classe Cliente
class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String cpf;
    private int idade;
    private String email;

    public Cliente(int id, String nome, String telefone, String cpf, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }
}
