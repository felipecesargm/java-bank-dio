package banco.conta;
import banco.cliente.Cliente;
public class Corrente extends Conta {
    protected boolean cartaoCredito;
    public Corrente(Cliente cliente, boolean cartaoCredito, String tipo) {
        super(cliente, tipo);
        this.cartaoCredito = cartaoCredito;
    }
    public void setCartaoCredito(boolean cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    public boolean isCartaoCredito() {
        return cartaoCredito;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("-- Extrato Conta Corrente --");
        if(isCartaoCredito()==true) System.out.println("Cartão de Crédito: Sim");
        else System.out.println("Cartão de Crédito: Não");

        super.imprimirDados();
    }
}
