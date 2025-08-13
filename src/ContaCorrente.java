// A classe 'ContaCorrente' herda de 'Conta'.
// Ela é uma especialização de uma Conta, mas herda todos os atributos e métodos da classe pai.
public class ContaCorrente extends Conta {

    // O construtor de ContaCorrente chama o construtor da classe pai (Conta)
    // usando a palavra-chave 'super()'.
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    // O método 'imprimirExtrato()' está sendo sobrescrito (@Override).
    // Isso significa que esta classe fornece sua própria implementação do método,
    // que pode ser diferente da implementação da classe pai.
    @Override
    public void imprimirExtrato() {

        // Chama o método que imprime as informações comuns da classe pai (Conta).
        imprimirInfosComuns(); 

        // Chama o método que imprime o histórico de operações.
        imprimirHistoricoDeOperacoes();
    }
}