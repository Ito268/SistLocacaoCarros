package com.mycompany.sistemalocacaocarros;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TelaLocacao extends JFrame {
    private JLabel lblModelo, lblMarca, lblPlaca, lblCor, lblDataLocacao;
    private JTextField txtModelo, txtMarca, txtPlaca, txtCor, txtDataLocacao;
    private JButton btnLocar, btnCancelar;
    private Carro carroSelecionado;

    public TelaLocacao(Carro carro) {
        // Inicializando a instância do carro selecionado
        this.carroSelecionado = carro;

        // Configurando a interface gráfica
        setTitle("Tela de Locação de Carro");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Labels
        lblModelo = new JLabel("Modelo:");
        lblMarca = new JLabel("Marca:");
        lblPlaca = new JLabel("Placa:");
        lblCor = new JLabel("Cor:");
        lblDataLocacao = new JLabel("Data de Locação:");

        // Campos de texto
        txtModelo = new JTextField();
        txtMarca = new JTextField();
        txtPlaca = new JTextField();
        txtCor = new JTextField();
        txtDataLocacao = new JTextField();

        // Definir os campos com as informações do carro
        txtModelo.setText(carro.getModelo());
        txtMarca.setText(carro.getMarca());
        txtPlaca.setText(carro.getPlaca());
        txtCor.setText(carro.getCor());

        // Formatar a data atual como String no formato DD/MM/AAAA
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = sdf.format(new Date()); // Formata a data atual

        txtDataLocacao.setText(dataAtual); // Definindo data de locação como a data atual

        // Desabilitar os campos de texto para que o usuário não altere
        txtModelo.setEditable(false);
        txtMarca.setEditable(false);
        txtPlaca.setEditable(false);
        txtCor.setEditable(false);
        txtDataLocacao.setEditable(false);

        // Botões
        btnLocar = new JButton("Locar");
        btnCancelar = new JButton("Cancelar");

        // Ação ao clicar em "Locar"
        btnLocar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carroSelecionado.isDisponivel()) {
                    // Atualizando a locação do carro
                    carroSelecionado.setDisponivel(false);
                    carroSelecionado.setClienteIdCarro(123); // Aqui você pode pegar o ID do cliente
                    carroSelecionado.setDataLocacao(dataAtual); // Atualizando a data de locação com a data atual

                    // Mostrar uma mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Carro alugado com sucesso!");

                    // Fechar a janela após a locação
                    dispose();
                } else {
                    // Exibir erro se o carro não estiver disponível
                    JOptionPane.showMessageDialog(null, "O carro não está disponível para locação.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação ao clicar em "Cancelar"
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Adicionando os componentes na tela
        add(lblModelo);
        add(txtModelo);
        add(lblMarca);
        add(txtMarca);
        add(lblPlaca);
        add(txtPlaca);
        add(lblCor);
        add(txtCor);
        add(lblDataLocacao);
        add(txtDataLocacao);
        add(btnLocar);
        add(btnCancelar);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Passando parâmetros válidos para o construtor de Carro
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataInicial = sdf.format(new Date()); // Data inicial

        Carro carro = new Carro(1, "Corolla", "Toyota", "ABC-1234", "Prata", true, null, dataInicial, null);
        new TelaLocacao(carro);
    }
}
