import java.time.LocalDateTime;

public class Transacao {
    private String descricao;
    private double valor;
    private LocalDateTime data;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDateTime.now(); // Define a data e hora da transação como o momento atual
    }
  
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
