package com.mycompany.sistemalocacaocarros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {

    private JTextField campoNome, campoIdade, campoCPF, campoIdCliente;
    private JButton botaoCadastrar;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelNome = new JLabel("Nome:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelNome, gbc);

        campoNome = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(campoNome, gbc);

        JLabel labelIdade = new JLabel("Idade:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelIdade, gbc);

        campoIdade = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(campoIdade, gbc);

        JLabel labelCPF = new JLabel("CPF:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelCPF, gbc);

        campoCPF = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(campoCPF, gbc);

        JLabel labelIdCliente = new JLabel("ID Cliente:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(labelIdCliente, gbc);

        campoIdCliente = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(campoIdCliente, gbc);

        botaoCadastrar = new JButton("Cadastrar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(botaoCadastrar, gbc);

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
    }

    private void cadastrarCliente() {
        String nome = campoNome.getText();
        String idadeTexto = campoIdade.getText();
        String cpf = campoCPF.getText();
        String idTexto = campoIdCliente.getText();

        if (nome.isEmpty() || idadeTexto.isEmpty() || cpf.isEmpty() || idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idade = Integer.parseInt(idadeTexto);
            int idCliente = Integer.parseInt(idTexto);

            // Aqui podemos adicionar código para salvar no banco de dados.
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade e ID Cliente devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoIdade.setText("");
        campoCPF.setText("");
        campoIdCliente.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroCliente().setVisible(true));
    }
}
