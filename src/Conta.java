import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// A classe 'Conta' é 'abstract', o que significa que ela não pode ser instanciada diretamente.
// Ela serve como um modelo base para as classes filhas (ContaCorrente, ContaPoupanca)
// que herdam seus atributos e comportamentos.
public abstract class Conta implements Iconta {

    // Constantes estáticas e finais (valores que não mudam).
    // 'static' significa que a variável pertence à classe, não ao objeto.
    // 'final' significa que o valor é constante.
    private static  final int AGENCIA_PADRAO = 1206;
    private static  final AtomicInteger SEQUENCIAL = new AtomicInteger(1206);
    
    // Atributos protegidos, acessíveis pelas classes filhas.
    protected int numeroAgencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente cliente; 
    
    // Lista para armazenar objetos da classe Transacao.
    // Esta é uma melhoria para organizar o histórico de operações de forma mais estruturada.
    protected List<Transacao> historicoDeOperacoes = new ArrayList<>();
    
    // Construtor da classe Conta.
    public Conta(Cliente cliente) {
        this.numeroAgencia = AGENCIA_PADRAO;
        // Usa o AtomicInteger para gerar um número de conta único e sequencial.
        this.numeroConta = SEQUENCIAL.getAndIncrement();
        this.cliente = cliente; 
    }
  
    // Métodos "Getters" para acessar os dados da conta.
    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    } 

    // Métodos que implementam a interface Iconta.
    @Override
    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            // Cria um objeto Transacao e o adiciona ao histórico.
            historicoDeOperacoes.add(new Transacao("SAQUE DE R$ %.2f realizado com sucesso!".formatted(valor), valor));
        } else {
            // Se a operação for inválida, registra uma transação de erro.
            historicoDeOperacoes.add(new Transacao("SAQUE inválido ou saldo insuficiente.", 0));
        }
    }
    
    @Override
    public void depositar(double valor) { 
        if (valor > 0) {
            this.saldo += valor;
            historicoDeOperacoes.add(new Transacao("DEPÓSITO DE R$ %.2f realizado com sucesso!".formatted(valor), valor));
        } else {
            historicoDeOperacoes.add(new Transacao("VALOR DE DEPÓSITO inválido.", 0));
        }
    }
   
    @Override
    public void transferir(double valor, Conta contaDestino) {
       if (valor > 0 && this.saldo >= valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        historicoDeOperacoes.add(new Transacao("TRANSFERÊNCIA DE R$ %.2f para a conta %d realizada com sucesso!".formatted(valor, contaDestino.getNumeroConta()), valor));
         } else {
            historicoDeOperacoes.add(new Transacao("TRANSFERÊNCIA inválida ou saldo insuficiente.", 0));
       }
    }

    // Métodos para imprimir informações do extrato.
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
        System.out.println("EXTRATO MÊS PARA SIMPLES CONFERÊNCIA");
        System.out.println("ULTIMOS 30 DIAS");
        System.out.println("---------------------------------------------");
    }

    // Este método agora itera sobre a lista de objetos Transacao.
    protected void imprimirHistoricoDeOperacoes() {
        for (Transacao operacao : historicoDeOperacoes) {
            System.out.println("  - " + operacao.getDescricao() + " em " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(operacao.getData()));
        }
        System.out.println("---------------------------------------------");
        System.out.println(String.format("SALDO TOTAL: R$ %.2f", this.saldo));
        System.out.println("=============================================");
    }
    
    @Override
    public void imprimirExtrato() {
        imprimirInfosComuns();
        imprimirHistoricoDeOperacoes();
    }
}