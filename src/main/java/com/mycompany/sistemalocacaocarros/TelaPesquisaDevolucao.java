package com.mycompany.sistemalocacaocarros;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaPesquisaDevolucao extends JFrame {

    private JTextField txtModelo;
    private JComboBox<String> cbMarca, cbCor;
    private JButton btnPesquisar;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private List<Carro> listaCarros;

    public TelaPesquisaDevolucao() {
        setTitle("Pesquisa de Carros Indisponíveis");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da interface
        JLabel lblModelo = new JLabel("Modelo:");
        JLabel lblMarca = new JLabel("Marca:");
        JLabel lblCor = new JLabel("Cor:");

        txtModelo = new JTextField(15);

        String[] marcas = {"Todas", "Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "Fiat", "Hyundai", "Nissan"};
        cbMarca = new JComboBox<>(marcas);

        String[] cores = {"Todas", "Preto", "Branco", "Prata", "Vermelho", "Azul", "Cinza", "Verde"};
        cbCor = new JComboBox<>(cores);

        btnPesquisar = new JButton("Pesquisar");

        // Tabela de resultados
        String[] colunas = {"Modelo", "Marca", "Placa", "Cor", "Disponível", "Ação"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);
        tabela.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(750, 350));

        // Posicionando componentes
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
        add(lblCor, gbc);
        gbc.gridx = 1;
        add(cbCor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnPesquisar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(scrollPane, gbc);

        // Inicializar lista de carros
        inicializarCarros();

        // Evento do botão de pesquisa
        btnPesquisar.addActionListener(this::filtrarCarros);

        // Configurar a tabela para suportar o botão de devolução
        tabela.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        tabela.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

        setVisible(true);
    }

    private void inicializarCarros() {
    listaCarros = new ArrayList<>();

    listaCarros.add(new Carro(1, "Corolla", "Toyota", "ABC-1234", "Prata", false, 123, "10/02/2025", "12/02/2025"));
    listaCarros.add(new Carro(2, "Civic", "Honda", "DEF-5678", "Preto", false, 456, "11/02/2025", "13/02/2025"));
    listaCarros.add(new Carro(3, "Fusion", "Ford", "GHI-9012", "Azul", false, 789, "12/02/2025", "14/02/2025"));
    listaCarros.add(new Carro(4, "Cruze", "Chevrolet", "JKL-3456", "Branco", false, 101, "13/02/2025", "15/02/2025"));
    listaCarros.add(new Carro(5, "Golf", "Volkswagen", "MNO-7890", "Vermelho", false, 112, "14/02/2025", "16/02/2025"));
    listaCarros.add(new Carro(6, "Fiesta", "Ford", "PQR-2345", "Cinza", false, 113, "15/02/2025", "17/02/2025"));
    listaCarros.add(new Carro(7, "Tucson", "Hyundai", "STU-6789", "Verde", false, 114, "16/02/2025", "18/02/2025"));
    listaCarros.add(new Carro(8, "Sentra", "Nissan", "VWX-1234", "Amarelo", false, 115, "17/02/2025", "19/02/2025"));

    atualizarTabela(listaCarros);
}



    private void filtrarCarros(ActionEvent e) {
        String modeloPesquisa = txtModelo.getText().toLowerCase();
        String marcaPesquisa = (String) cbMarca.getSelectedItem();
        String corPesquisa = (String) cbCor.getSelectedItem();

        List<Carro> resultados = new ArrayList<>();

        for (Carro carro : listaCarros) {
            boolean modeloOk = modeloPesquisa.isEmpty() || carro.getModelo().toLowerCase().contains(modeloPesquisa);
            boolean marcaOk = marcaPesquisa.equals("Todas") || carro.getMarca().equals(marcaPesquisa);
            boolean corOk = corPesquisa.equals("Todas") || carro.getCor().equals(corPesquisa);
            boolean disponibilidadeOk = !carro.isDisponivel();  // Só carros indisponíveis

            if (modeloOk && marcaOk && corOk && disponibilidadeOk) {
                resultados.add(carro);
            }
        }

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum carro encontrado com os filtros selecionados.", "Resultado da Pesquisa", JOptionPane.INFORMATION_MESSAGE);
        }

        atualizarTabela(resultados);
    }

    private void atualizarTabela(List<Carro> carros) {
        modeloTabela.setRowCount(0);
        for (Carro carro : carros) {
            modeloTabela.addRow(new Object[] {
                    carro.getModelo(),
                    carro.getMarca(),
                    carro.getPlaca(),
                    carro.getCor(),
                    carro.isDisponivel() ? "Sim" : "Não",
                    "Devolver" // Texto para o botão na célula
            });
        }
    }

    public static void main(String[] args) {
        new TelaPesquisaDevolucao();
    }

    // Renderiza o botão na célula da tabela
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setText("Devolver");
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Edita a célula com o botão e chama a ação ao clicar
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> {
                int row = tabela.getSelectedRow();
                Carro carro = listaCarros.get(row);

                // Ao clicar no botão, redireciona para a TelaDevolucao
                new TelaDevolucao(carro);
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText((value == null) ? "Devolver" : value.toString());
            return button;
        }
    }
}
