package com.mycompany.sistemalocacaocarros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginFuncionario extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;

    public TelaLoginFuncionario() {
        setTitle("Login do Funcionário"); // Título da janela
        setSize(350, 200); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(new GridBagLayout()); // Usa um layout para organizar melhor os elementos

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os elementos

        JLabel labelUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelUsuario, gbc);

        campoUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(campoUsuario, gbc);

        JLabel labelSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelSenha, gbc);

        campoSenha = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(campoSenha, gbc);

        botaoLogin = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(botaoLogin, gbc);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                if (validarLogin(usuario, senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    dispose(); // Fecha a tela de login
                    // Aqui você pode abrir a próxima tela do sistema
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean validarLogin(String usuario, String senha) {
        // Simulação de um login fixo para teste
        return usuario.equals("admin") && senha.equals("12345678");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLoginFuncionario().setVisible(true));
    }
}
