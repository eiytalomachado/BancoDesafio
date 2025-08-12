import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Conta implements Iconta {

    private static  final int AGENCIA_PADRÃO = 1206;
    private static  final AtomicInteger SEQUENCIAL = new AtomicInteger(1206);
    // Gera um número sequencial único para cada nova conta, começando em 1.
    // O AtomicInteger garante que esse número seja seguro em ambientes com múltiplas threads.

    protected int numeroAgencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente cliente; // Adicionando o cliente para associar a conta
    protected List<String> historicoDeOperacoes = new ArrayList<>();
    
    public Conta(Cliente cliente) {
        this.numeroAgencia = AGENCIA_PADRÃO;
        this.numeroConta = SEQUENCIAL.getAndIncrement();
        this.cliente = cliente; // Inicializando o cliente
    }
  
    //Getters para ler os dados da conta
    //Settes para modificar os dados da conta, se necessário.

    public int getNumeroAgencia() {
        return numeroAgencia;

    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    } 

  
    @Override
    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            historicoDeOperacoes.add(String.format("SAQUE DE R$ %.2f realizado com sucesso!", valor));
        } else {
            // Adiciona a transação falha ao histórico
            historicoDeOperacoes.add("SAQUE inválido ou saldo insuficiente.");
        }
    }
    
    @Override
    public void depositar(double valor) { 
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            historicoDeOperacoes.add(String.format("DEPÓSITO DE R$ %.2f realizado com sucesso!", valor));
        } else {
            historicoDeOperacoes.add("VALOR DEDEPÓSITO inválido.");
        }
    }
   
    @Override
    public void transferir(double valor, Conta contaDestino) {
       if (valor > 0 && this.saldo >= valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        historicoDeOperacoes.add(String.format("TRANSFERÊNCIA DE R$ %.2f para a conta %d realizada com sucesso!", valor, contaDestino.getNumeroConta()));
         } else {
            historicoDeOperacoes.add("TRANSFERÊNCIA inválida ou saldo insuficiente.");
       }
    }

    protected void imprimirInfosComuns() {

        System.out.println("=============================================");
        System.out.println("        AUTOATENDIMENTO - CEF UTINGA");
        System.out.println(String.format("DATA: %s         HORA: %s",
        DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()),
        DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        System.out.println(String.format("AGÊNCIA: %d - UTINGA, SP", this.numeroAgencia));
        System.out.println(String.format("CONTA: %03d.%03d.%03d-%d", this.numeroConta / 100000000, (this.numeroConta % 100000000) / 100000, (this.numeroConta % 100000) / 10, this.numeroConta % 10));
        System.out.println(String.format("CLIENTE: %s", this.cliente.getNome().toUpperCase()));
        System.out.println("=============================================");
        System.out.println("EXTRATO MES PARA SIMPLES CONFERENCIA");
        System.out.println("ULTIMOS 30 DIAS");
        System.out.println("---------------------------------------------");
    }

    // Método para imprimir o histórico de transações
    protected void imprimirHistoricoDeOperacoes() {
        for (String operacao : historicoDeOperacoes) {
            System.out.println("  - " + operacao);
        }
        System.out.println("---------------------------------------------");
        System.out.println(String.format("SALDO TOTAL: R$ %.2f", this.saldo));
        System.out.println("=============================================");
    }
    
    // O método principal que une as duas partes do extrato
    @Override
    public void imprimirExtrato() {
        imprimirInfosComuns();
        imprimirHistoricoDeOperacoes();
    }
}
        
