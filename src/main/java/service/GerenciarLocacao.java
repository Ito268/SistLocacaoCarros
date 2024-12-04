/*
package service;
import model.Carro;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class GerenciarLocacao {
    private List<Carro> carros = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    // Método para cadastrar um carro no sistema
    public void cadastrarCarro(Carro carro) {
        carros.add(carro);
        System.out.println("Carro cadastrado: " + carro);
    }

    // Método para cadastrar um cliente no sistema
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente);
    }

    // Método para alugar um carro para um cliente específico
    public boolean alugarCarro(int clienteId, int carroId) {
        Carro carro = encontrarCarroPorId(carroId);
        Cliente cliente = encontrarClientePorId(clienteId);

        if (carro != null && cliente != null && carro.isDisponivel()) {
            carro.setDisponivel(false);  // Marca o carro como indisponível
            carro.setClienteId(clienteId);  // Associa o carro ao cliente
            System.out.println("Carro " + carroId + " alugado para o cliente " + clienteId);
            return true;
        } else {
            System.out.println("Locação não foi possível. Verifique a disponibilidade do carro ou os IDs.");
            return false;
        }
    }

    // Método para devolver um carro
    public boolean devolverCarro(int carroId) {
        Carro carro = encontrarCarroPorId(carroId);

        if (carro != null && !carro.isDisponivel()) {
            carro.setDisponivel(true);  // Marca o carro como disponível
            carro.setClienteId(null);   // Remove a associação com o cliente
            System.out.println("Carro " + carroId + " devolvido com sucesso.");
            return true;
        } else {
            System.out.println("Devolução não foi possível. Verifique o ID do carro.");
            return false;
        }
    }

    // Método auxiliar para encontrar um carro por ID
    private Carro encontrarCarroPorId(int carroId) {
        for (Carro carro : carros) {
            if (carro.getId() == carroId) {
                return carro;
            }
        }
        return null;
    }

    // Método auxiliar para encontrar um cliente por ID
    private Cliente encontrarClientePorId(int clienteId) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == clienteId) {
                return cliente;
            }
        }
        return null;
    }
}
*/