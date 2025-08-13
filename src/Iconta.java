// Uma 'interface' define um "contrato". Ela declara um conjunto de métodos
// que uma classe deve implementar. Pense nela como uma lista de requisitos.
// Qualquer classe que implemente 'Iconta' (como a classe 'Conta') precisa
// fornecer uma implementação para todos os métodos listados aqui.
public interface Iconta {

   // Métodos sem corpo, apenas a assinatura.
   public void sacar(double valor);
   public void depositar(double valor);
   public void transferir(double valor, Conta contaDestino);
   public void imprimirExtrato();
}