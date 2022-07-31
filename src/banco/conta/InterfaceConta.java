package banco.conta;
public interface InterfaceConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(int numeroContaDestino, double valor);
    void imprimirExtrato();
}
