package com.mycompany.sistemalocacaocarros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastroVeiculo extends JFrame {

    private JTextField txtModelo, txtPlaca, txtCor;
    private JComboBox<String> cbMarca;
    private JButton btnCadastrar;

    public TelaCadastroVeiculo() {
        setTitle("Cadastro de Veículo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels
        JLabel lblModelo = new JLabel("Modelo:");
        JLabel lblMarca = new JLabel("Marca:");
        JLabel lblPlaca = new JLabel("Placa:");
        JLabel lblCor = new JLabel("Cor:");

        // Campos de entrada
        txtModelo = new JTextField(15);
        txtPlaca = new JTextField(10);
        txtCor = new JTextField(10);

        // ComboBox para selecionar marcas
        String[] marcas = {"Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "Fiat", "Hyundai", "Nissan"};
        cbMarca = new JComboBox<>(marcas);

        btnCadastrar = new JButton("Cadastrar");

        // Posicionando os componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblModelo, gbc);
        gbc.gridx = 1;
        add(txtModelo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblMarca, gbc);
        gbc.gridx = 1;
        add(cbMarca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblPlaca, gbc);
        gbc.gridx = 1;
        add(txtPlaca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblCor, gbc);
        gbc.gridx = 1;
        add(txtCor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnCadastrar, gbc);

        // Evento do botão de cadastro
        btnCadastrar.addActionListener(this::cadastrarVeiculo);

        setVisible(true);
    }

    private void cadastrarVeiculo(ActionEvent e) {
        String modelo = txtModelo.getText().trim();
        String marca = (String) cbMarca.getSelectedItem();
        String placa = txtPlaca.getText().trim();
        String cor = txtCor.getText().trim();

        if (modelo.isEmpty() || placa.isEmpty() || cor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!placa.matches("[A-Z]{3}-\\d{4}")) {
            JOptionPane.showMessageDialog(this, "A placa deve estar no formato ABC-1234.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!", "Cadastro Concluído", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new TelaCadastroVeiculo();
    }
}
