import java.util.List;
import java.util.ArrayList;

public class Banco {
    
    private static final String NOME_BANCO = "Caixa Econômica Federal";

    //private List<Conta> contas; e private List<Cliente> clientes;: Aqui, o código cria duas "listas".
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();  
    }

    //Getters para ler os dados da conta
    //Settes para modificar os dados da conta, se necessário.
     public String getNomeBanco() {
        return NOME_BANCO;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }
}
