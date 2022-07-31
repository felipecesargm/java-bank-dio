package banco.conta;
import banco.cliente.Cliente;
public class Poupanca extends Conta {
    public Poupanca(Cliente cliente, String tipo) {
        super(cliente, tipo);

    }
    @Override
    public void imprimirExtrato() {
        System.out.println("-- Extrato Conta Pupança -- ");
        super.imprimirDados();

    }
}
