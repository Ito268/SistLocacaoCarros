package com.mycompany.sistemalocacaocarros;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TelaDevolucao extends JFrame {
    private JLabel lblModelo, lblPlaca, lblDataLocacao, lblDataDevolucao, lblValorDiaria, lblValorExtra, lblOutros, lblValorTotal, lblObservacoes;
    private JTextField txtOutros;
    private JTextArea txtObservacoes;
    private JButton btnCalcular, btnFinalizar, btnManutencao;

    private Carro carro;
    private double valorDiaria = 100.0;
    private double valorTotal = 0.0;

    public TelaDevolucao(Carro carro) {
        this.carro = carro;
        setTitle("Tela de Devolução");
        setSize(450, 600); // Aumentado para melhor disposição
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        
        // Componentes da interface
        lblModelo = new JLabel("Modelo: " + carro.getModelo());
        lblPlaca = new JLabel("Placa: " + carro.getPlaca());
        lblDataLocacao = new JLabel("Data de Locação: " + carro.getDataLocacao());
        lblDataDevolucao = new JLabel("Data de Devolução: " + carro.getDataDevolucao());
        lblValorDiaria = new JLabel("Valor da Diária: R$ " + valorDiaria);
        lblValorExtra = new JLabel("Valor Extra (Multa): R$ 0.00");
        lblOutros = new JLabel("Outros:");
        lblValorTotal = new JLabel("Valor Total: R$ 0.00");
        lblObservacoes = new JLabel("Observações:");

        txtOutros = new JTextField("0.00", 15);
        txtObservacoes = new JTextArea(5, 30); // Aumentado para melhor edição
        JScrollPane scrollObservacoes = new JScrollPane(txtObservacoes);
        scrollObservacoes.setPreferredSize(new Dimension(400, 80));

        btnCalcular = new JButton("Calcular");
        btnFinalizar = new JButton("Finalizar Operação");
        btnManutencao = new JButton("Enviar para Manutenção");

        // Redimensionar botões
        Dimension btnSize = new Dimension(180, 35);
        btnCalcular.setPreferredSize(btnSize);
        btnFinalizar.setPreferredSize(btnSize);
        btnManutencao.setPreferredSize(btnSize);

        // Adicionando os componentes à tela
        gbc.gridy = 0;
        add(lblModelo, gbc);
        
        gbc.gridy++;
        add(lblPlaca, gbc);

        gbc.gridy++;
        add(lblDataLocacao, gbc);

        gbc.gridy++;
        add(lblDataDevolucao, gbc);

        gbc.gridy++;
        add(lblValorDiaria, gbc);

        gbc.gridy++;
        add(lblValorExtra, gbc);

        gbc.gridy++;
        add(lblOutros, gbc);
        gbc.gridwidth = 1;
        add(txtOutros, gbc);
        gbc.gridwidth = 2;

        gbc.gridy++;
        add(lblValorTotal, gbc);

        gbc.gridy++;
        add(lblObservacoes, gbc);
        gbc.gridy++;
        add(scrollObservacoes, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        add(btnCalcular, gbc);
        add(btnFinalizar, gbc);
        gbc.gridy++;
        add(btnManutencao, gbc);

        // Eventos dos botões
        btnCalcular.addActionListener(e -> calcularValor());
        btnFinalizar.addActionListener(e -> finalizarDevolucao());
        btnManutencao.addActionListener(e -> enviarParaManutencao());

        setVisible(true);
    }

    private void calcularValor() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLocacao = LocalDate.parse(carro.getDataLocacao(), formatter);
            LocalDate dataDevolucao = LocalDate.parse(carro.getDataDevolucao(), formatter);
            LocalDate hoje = LocalDate.now();

            long diasRodados = ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
            if (diasRodados < 1) diasRodados = 1;

            double valorDiarias = diasRodados * valorDiaria;
            double multa = dataDevolucao.isAfter(hoje) ? 150.00 : 100.00;
            double outros = Double.parseDouble(txtOutros.getText());

            valorTotal = valorDiarias + multa + outros;

            lblValorExtra.setText("Valor Extra (Multa): R$ " + (multa == 150.00 ? "150.00" : "0.00"));
            lblValorTotal.setText("Valor Total: R$ " + String.format("%.2f", valorTotal));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao calcular valores. Verifique as datas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void finalizarDevolucao() {
        carro.setDisponivel(true);
        carro.setClienteIdCarro(null);
        carro.setDataLocacao(null);
        carro.setDataDevolucao(null);

        JOptionPane.showMessageDialog(this, "Devolução concluída! O carro agora está disponível para locação.", 
                                      "Operação Finalizada", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void enviarParaManutencao() {
        carro.setDisponivel(false);

        JOptionPane.showMessageDialog(this, "O carro foi enviado para manutenção e está indisponível para locação.", 
                                      "Enviado para Manutenção", JOptionPane.WARNING_MESSAGE);
        dispose();
    }

    public static void main(String[] args) {
        Carro carro = new Carro(1, "Corolla", "Toyota", "ABC-1234", "Prata", false, 123, "10/02/2025", "12/02/2025");
        new TelaDevolucao(carro);
    }
}
