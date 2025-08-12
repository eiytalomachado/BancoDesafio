public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {

        // Chama o método que imprime as informações comuns
        imprimirInfosComuns(); 

        // Chama o método que imprime o histórico de operações
        imprimirHistoricoDeOperacoes();
    }
}