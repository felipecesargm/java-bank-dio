package banco;
import banco.cliente.Cliente;
import banco.conta.Conta;
import banco.conta.Corrente;
import banco.conta.Poupanca;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        //Criando clientes
        Cliente.adicionarCliente("Felipe Cesar", "12332112345", "Daniel dos Santos, 137");
        Cliente.adicionarCliente("Fulano Souza", "45665445678", "Daniel dos Santos, 15");
        Cliente.adicionarCliente("Fabio Souza", "45665445678", "Daniel dos Santos, 15");
        System.out.println("Listagem de clientes");

        //Removendo um cliente por id
        //Cliente.removerCliente(100);

        //Listando clientes
        Cliente.listarClientes();

        //Criação de conta
        Conta.criarConta(100, "poupanca");
        Conta.criarConta(101, "poupanca");
        Conta.criarConta(102, "poupanca");
        Conta.criarConta(100, "corrente");
        Conta.criarConta(101, "corrente");
        Conta.criarConta(102, "corrente");

        //Listando todas as contas e Listagem por id usando a sobrecarga
        System.out.println("Listagem de todas as contas");
        Conta.listarConta();
        System.out.println("Listagem por id (sobrecarga)");
        Conta.listarConta(100);

        //Teste dos métodos: imprimirExtrato, depositar, transferir e sacar
        Cliente fabricio = new Cliente("Fabricio Rael", "78998778965", "Rua dos Alfeneiros, 1211");
        Cliente.clientes.add(fabricio);

        Conta contaFabricio = new Corrente(fabricio, true, "corrente");
        Conta.contas.add(contaFabricio);
        System.out.println();

       contaFabricio.imprimirExtrato();
       contaFabricio.depositar(1000);
       contaFabricio.transferir(1002, 500);
       contaFabricio.sacar(250);

       Conta.listarConta();
    }
}


