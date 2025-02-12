package com.mycompany.sistemalocacaocarros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TelaPesquisaCarro extends JFrame {
    private JComboBox<String> cbMarca, cbCor;
    private JTextField txtModelo;
    private JCheckBox chkDisponivel;
    private JButton btnPesquisar;
    private JTable tabelaCarros;
    private DefaultTableModel modeloTabela;

    public TelaPesquisaCarro() {
        setTitle("Pesquisa de Carros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de Filtros
        JPanel painelFiltros = new JPanel();
        painelFiltros.setLayout(new GridLayout(2, 4, 5, 5));

        painelFiltros.add(new JLabel("Marca:"));
        cbMarca = new JComboBox<>(new String[]{"", "Toyota", "Honda", "Ford", "Chevrolet"});
        painelFiltros.add(cbMarca);

        painelFiltros.add(new JLabel("Cor:"));
        cbCor = new JComboBox<>(new String[]{"", "Branco", "Preto", "Vermelho", "Azul"});
        painelFiltros.add(cbCor);

        painelFiltros.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        painelFiltros.add(txtModelo);

        chkDisponivel = new JCheckBox("Apenas disponíveis");
        painelFiltros.add(chkDisponivel);

        btnPesquisar = new JButton("Pesquisar");
        painelFiltros.add(btnPesquisar);

        add(painelFiltros, BorderLayout.NORTH);

        // Tabela de Resultados
        String[] colunas = {"ID", "Modelo", "Marca", "Cor", "Disponível"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaCarros = new JTable(modeloTabela);
        add(new JScrollPane(tabelaCarros), BorderLayout.CENTER);

        // Ação do botão "Pesquisar"
        btnPesquisar.addActionListener(e -> pesquisarCarros());

        setVisible(true);
    }

    private void pesquisarCarros() {
        // Simulando uma busca (troque isso por uma consulta ao banco de dados)
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1, "Corolla", "Toyota", "Branco", true));
        carros.add(new Carro(2, "Civic", "Honda", "Preto", false));

        // Pegando os filtros escolhidos
        String marca = (String) cbMarca.getSelectedItem();
        String cor = (String) cbCor.getSelectedItem();
        String modelo = txtModelo.getText().trim().toLowerCase();
        boolean apenasDisponiveis = chkDisponivel.isSelected();

        // Filtrando os carros
        List<Carro> carrosFiltrados = new ArrayList<>();
        for (Carro carro : carros) {
            if ((marca.isEmpty() || carro.getMarca().equalsIgnoreCase(marca)) &&
                (cor.isEmpty() || carro.getCor().equalsIgnoreCase(cor)) &&
                (modelo.isEmpty() || carro.getModelo().toLowerCase().contains(modelo)) &&
                (!apenasDisponiveis || carro.isDisponivel())) {
                carrosFiltrados.add(carro);
            }
        }

        // Atualizando a tabela
        modeloTabela.setRowCount(0);
        for (Carro carro : carrosFiltrados) {
            modeloTabela.addRow(new Object[]{
                carro.getIdCarro(),
                carro.getModelo(),
                carro.getMarca(),
                carro.getCor(),
                carro.isDisponivel() ? "Sim" : "Não"
            });
        }
    }

    // Classe interna para representar um Carro (substitua pela sua classe real)
    static class Carro {
        private int idCarro;
        private String modelo;
        private String marca;
        private String cor;
        private boolean disponivel;

        public Carro(int idCarro, String modelo, String marca, String cor, boolean disponivel) {
            this.idCarro = idCarro;
            this.modelo = modelo;
            this.marca = marca;
            this.cor = cor;
            this.disponivel = disponivel;
        }

        public int getIdCarro() { return idCarro; }
        public String getModelo() { return modelo; }
        public String getMarca() { return marca; }
        public String getCor() { return cor; }
        public boolean isDisponivel() { return disponivel; }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaPesquisaCarro::new);
    }
}
