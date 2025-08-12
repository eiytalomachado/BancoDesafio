public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=========================================");
        System.out.println("             CAIXA");
        System.out.println("        CAIXA ECONOMICA FEDERAL");
        System.out.println("     AUTOATENDIMENTO - CEF UTINGA");
        System.out.println("=========================================");

        // Chama o método que imprime as informações comuns
        imprimirInfosComuns(); 

        // Chama o método que imprime o histórico de operações
        imprimirHistoricoDeOperacoes();

        System.out.println("=========================================");
    }
}