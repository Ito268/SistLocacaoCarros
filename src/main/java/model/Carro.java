package model;

public class Carro {
    private int idCarro;
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private boolean disponivel;
    private Integer clienteIdCarro; // ID do cliente atual (null se disponível)

    // Construtor
    public Carro(int idCarro, String placa, String modelo, String marca, String cor) {
        this.idCarro = idCarro;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.disponivel = true;
        this.clienteIdCarro = null;
    }

    // Getters e Setters
    public int getId() {
        return idCarro;
    }
    
    public String getPlaca(){
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
    
    public String getCor(){
        return cor;
    }

    public boolean getDisponivel() {
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

    @Override
    public String toString() {
        return "Carro [ID=" + idCarro + ", placa=" + placa + ", Modelo=" + modelo + ", Marca=" + marca + ", Cor=" + cor +", Disponível=" + disponivel + "]";
    }
}
