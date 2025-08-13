// Este é o arquivo principal onde o programa começa a ser executado.
// A classe App é responsável por orquestrar a criação do banco, clientes e contas,
// e por demonstrar as operações (depósito, saque e transferência).
public class App {
    
    // O método 'main' é o ponto de entrada de qualquer aplicação Java.
    // O modificador 'static' significa que ele pertence à classe, não a uma instância.
    public static void main(String[] args) throws Exception {

        // ======================= 1. Configuração Inicial =======================
        
        // Criação de uma instância da classe Banco.
        // O banco será o "container" que gerencia todos os clientes e contas.
        Banco meuBanco = new Banco();
        System.out.println("Nome do Banco: " + meuBanco.getNomeBanco());

        // ======================= 2. Criação de Clientes e Contas =======================

        // Criação de dois clientes.
        // Cada cliente é uma instância da classe Cliente, com seu nome.
        Cliente cliente1 = new Cliente("João da Silva");    
        Cliente cliente2 = new Cliente("Maria Oliveira");

        // Adicionando os clientes à lista do banco.
        meuBanco.adicionarCliente(cliente1);
        meuBanco.adicionarCliente(cliente2);

        // Criação das contas, associando cada uma ao seu respectivo cliente.
        // A ContaCorrente e a ContaPoupanca são tipos específicos de Conta.
        Conta contaCorrenteJoaoDaSilva = new ContaCorrente(cliente1);
        Conta contaPoupancaMariaOliveira = new ContaPoupanca(cliente2);

        // Adicionando as contas à lista do banco.
        meuBanco.adicionarConta(contaCorrenteJoaoDaSilva);
        meuBanco.adicionarConta(contaPoupancaMariaOliveira);

        // ======================= 3. Realizando Operações =======================
       
        // Demonstração de Depósitos na conta corrente de João.
        // Cada operação é registrada no histórico da conta.
        System.out.println("\n--- Realizando Depósitos na Conta de João ---");
        contaCorrenteJoaoDaSilva.depositar(500.0);
        contaCorrenteJoaoDaSilva.depositar(20.2);
        contaCorrenteJoaoDaSilva.depositar(120.0);

        // Demonstração de Saque na conta corrente de João.
        System.out.println("\n--- Realizando Saque na Conta de João ---");
        contaCorrenteJoaoDaSilva.sacar(400.0);
        
        // Demonstração de Transferência da conta de João para a de Maria.
        System.out.println("\n--- Realizando Transferência de João para Maria ---");
        contaCorrenteJoaoDaSilva.transferir(100.0, contaPoupancaMariaOliveira);

        // ======================= 4. Imprimindo Extratos =======================
        
        // Imprimimos o extrato da conta corrente de João.
        System.out.println("\n--- Extrato da Conta Corrente de João ---");
        contaCorrenteJoaoDaSilva.imprimirExtrato();

        // E também o extrato da conta poupança de Maria, para ver o depósito da transferência.
        System.out.println("\n--- Extrato da Conta Poupança de Maria ---");
        contaPoupancaMariaOliveira.imprimirExtrato();
    }
}