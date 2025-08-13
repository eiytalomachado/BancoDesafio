// A classe 'ContaPoupanca' também herda de 'Conta', compartilhando a mesma base.
public class ContaPoupanca extends Conta {

    // Construtor que chama o construtor da classe pai (Conta).
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    // Sobrescrevemos o método 'imprimirExtrato' para ter um layout diferente.
    // Esta é a beleza da herança e polimorfismo: podemos ter comportamentos diferentes
    // para classes que compartilham a mesma base.
    @Override
    public void imprimirExtrato() {
        System.out.println("=========================================");
        System.out.println("             CAIXA");
        System.out.println("        CAIXA ECONOMICA FEDERAL");
        System.out.println("     AUTOATENDIMENTO - CEF UTINGA");
        System.out.println("=========================================");

        // Chama o método que imprime as informações comuns (data, cliente, agência, etc.).
        imprimirInfosComuns(); 

        // Chama o método que imprime o histórico de operações.
        imprimirHistoricoDeOperacoes();

        System.out.println("=========================================");
    }
}