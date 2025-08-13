import java.time.LocalDateTime;

// A classe 'Transacao' representa um registro de uma única operação bancária.
// Ela armazena a descrição, o valor e o momento em que a transação ocorreu.
public class Transacao {
    private String descricao;
    private double valor;
    private LocalDateTime data;

    // Construtor para criar uma nova transação.
    // Ele recebe a descrição e o valor, e a data e hora são definidas automaticamente.
    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDateTime.now(); // Pega a data e hora atuais.
    }
  
    // Métodos "Getters" para acessar as informações da transação de forma segura.
    public String getDescricao() {
        return descricao;
    }
    public double getValor() {
        return valor;
    }
    public LocalDateTime getData() {
        return data;
    }
}