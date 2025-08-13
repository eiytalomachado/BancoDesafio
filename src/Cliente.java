// A classe 'Cliente' representa uma entidade (uma pessoa) que possui uma conta bancária.
// Ela é simples e foca em manter as informações básicas do cliente, como o nome.
public class Cliente {
        
    // 'private' protege a variável, garantindo que o nome do cliente só
    // possa ser acessado ou modificado através dos métodos da classe.
    private String nome;

    // O construtor da classe. Ele é chamado quando um novo objeto Cliente é criado.
    // Ele recebe o nome como parâmetro e o armazena na variável 'nome' do objeto.
     public Cliente(String nome) {
        this.nome = nome;
    }

    // Método "Getter" que permite a outras classes obterem o nome do cliente.
    public String getNome() {
        return nome;
    }

    // O método 'toString()' é um método especial que retorna uma representação em texto do objeto.
    // É muito útil para imprimir informações do objeto de forma amigável para o usuário.
    @Override
    public String toString() {
        return "Cliente: " + nome;
    }
}