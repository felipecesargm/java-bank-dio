package banco.conta;
import banco.cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements InterfaceConta {
    public static List<Conta> contas = new ArrayList<>();
    protected Cliente cliente;
    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected static String tipo;
    private static int AgenciaPadrao = 0001;
    private static int Sequencial = 1001;
    public Conta(Cliente cliente, String tipo ) {
        this.agencia = AgenciaPadrao;
        this.numeroConta = Sequencial++;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public static String getTipo() {
        return tipo;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= this.saldo)
        this.saldo -= valor;
    }
    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }
    @Override
    public void transferir(int numeroContaDestino, double valor) {
        if(valor <= this.saldo) {
            this.sacar(valor);
        }
        for (Conta conta:contas) {
            if(conta.numeroConta == numeroContaDestino) {
                conta.depositar(valor);
            }

        }

    }

    @Override
    public String toString() {
        return "Conta (titular, agencia, conta, saldo)" + cliente + agencia + numeroConta + saldo;
    }
    public static void listarConta() {
        for (Conta conta: contas) {
            System.out.println("Titular: " + conta.cliente.getNome() + " Id: " + conta.cliente.getId() +
                    " Ag: " + conta.agencia + " Conta: " + conta.numeroConta + " Saldo: " + conta.saldo);
        }
    }
    public static void listarConta(int id) {
        for(Conta conta: contas) {
            if(conta.cliente.getId() == id) {
                System.out.println("Titular: " + conta.cliente.getNome() + " Id: " + conta.cliente.getId() +
                        " Ag: " + conta.agencia + " Conta: " + conta.numeroConta + " Saldo: " + conta.saldo);
            }
        }
    }
    public static void criarConta(int id, String tipoConta) {
        for(Cliente cliente:Cliente.clientes) {
            if(cliente.getId() == id) {
                if(tipoConta == "corrente"){
                    contas.add(new Corrente(cliente, false, "Conta Corrente" ));

                } else if (tipoConta == "poupanca") {
                    contas.add(new Poupanca(cliente,"Conta Poupança"));

                } else
                    System.out.println("Conta inválida!");
            }
        }
    }
    protected void imprimirDados() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numeroConta));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }

}
