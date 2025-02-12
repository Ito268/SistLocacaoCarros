package com.mycompany.sistemalocacaocarros;

public class Carro {
    private int idCarro;
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private boolean disponivel;
    private Integer clienteIdCarro;
    private String dataLocacao; // Alterado para String no formato DD/MM/AAAA
    private String dataDevolucao; // Alterado para String no formato DD/MM/AAAA

    public Carro(int idCarro, String modelo, String marca, String placa, String cor, boolean disponivel, Integer clienteIdCarro, String dataLocacao, String dataDevolucao) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.disponivel = disponivel;
        this.clienteIdCarro = clienteIdCarro;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    // Getters e Setters
    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getClienteIdCarro() {
        return clienteIdCarro;
    }

    public void setClienteIdCarro(Integer clienteIdCarro) {
        this.clienteIdCarro = clienteIdCarro;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // Método para formatar a data
    public String formatarData(String data) {
        return data;  // Como as datas já são strings no formato DD/MM/AAAA, não há necessidade de formatação
    }
}
