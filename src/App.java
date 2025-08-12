public class App {
    public static void main(String[] args) throws Exception {

        // Criação do banco
        Banco meuBanco = new Banco();
        System.out.println(meuBanco.getNomeBanco());

        // Criação de clientes
        Cliente cliente1 = new Cliente("João da Silva");    
        Cliente cliente2 = new Cliente("Maria Oliveira");

        
        // Adicionando clientes ao banco
        meuBanco.adicionarCliente(cliente1);
        meuBanco.adicionarCliente(cliente2);

        // Criação de contas para os clientes
        Conta contaCorrenteJoaoDaSilva = new ContaCorrente(cliente1);
        Conta contaPoupancaMariaOliveira = new ContaPoupanca(cliente2);

        // Adicionando contas ao banco
        meuBanco.adicionarConta(contaCorrenteJoaoDaSilva);
        meuBanco.adicionarConta(contaPoupancaMariaOliveira);

                                     /////// Realizando operações nas contas /////
       
    
       // Depósito
        contaCorrenteJoaoDaSilva.depositar(500.0);
        contaCorrenteJoaoDaSilva.depositar(20.2);
        contaCorrenteJoaoDaSilva.depositar(120.0);


        // Saque
        contaCorrenteJoaoDaSilva.sacar(400.0);
        

        // Transferência
        contaCorrenteJoaoDaSilva.transferir(100.0, contaPoupancaMariaOliveira);

        // Imprimindo extratos        
        contaCorrenteJoaoDaSilva.imprimirExtrato();

    }

}

