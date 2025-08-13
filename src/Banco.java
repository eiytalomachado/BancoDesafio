import java.util.List;
import java.util.ArrayList;

// A classe 'Banco' atua como um gerenciador central.
// Ela é responsável por manter as listas de clientes e contas que fazem parte da instituição.
public class Banco {
    
    // A palavra-chave 'static' indica que esta variável pertence à classe,
    // e não a uma instância específica. 'final' significa que seu valor não pode ser alterado.
    private static final String NOME_BANCO = "Caixa Econômica Federal";

    // 'private' indica que estas listas só podem ser acessadas por métodos dentro desta classe.
    // A List<Conta> armazena todas as contas do banco.
    private List<Conta> contas;
    // A List<Cliente> armazena todos os clientes do banco.
    private List<Cliente> clientes;

    // O construtor é chamado quando um novo objeto 'Banco' é criado.
    // Ele inicializa as listas 'contas' e 'clientes' como novas listas vazias.
    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();  
    }

    // Métodos "Getters" para fornecer acesso seguro às variáveis privadas.
    // Eles permitem que outras classes leiam os dados, mas não os modifiquem diretamente.
     public String getNomeBanco() {
        return NOME_BANCO;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // Métodos para adicionar novos clientes e contas ao banco.
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }
}