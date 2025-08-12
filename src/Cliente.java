public class Cliente {
        
    private String nome;

     public Cliente(String nome) {
        this.nome = nome;
    }

    //Getters para ler os dados da conta
    //Settes para modificar os dados da conta, se necessário.
    public String getNome() {
        return nome;

    }

    @Override
    public String toString() {
        return "Cliente: " + nome;
    }

       
}
