/**
 * Exemplo de uma classe simples em Java.
 */
public class Main {
    public static void main(String[] args) {
        /* Tipos de dados
          String -> "********".
          int -> Números sem casa decimal: 23
          double -> Números com casa decimal: 23.6
          float -> Número com casa decimal (64bits): 23.5f
          boolean -> true/false
        */

        /* Operadores
          Atribuição: =
          Aritiméticos: - + * / %(Modulo)
          Atribuição com incremento: -= += /= %=
          Incremento: ++
          Decremento: --
          Lógicos: && || !
          Comparação: == != < > <= >=
        */
        
        // Constante do tipo caracter.
        final String NOME = "Eric Ambiel";
        
        // Variavel inteira.
        int idade = 18;

        System.out.println("Seu nome é: " + NOME);
        System.out.println("Você tem: " + idade + " anos.");

        // Estruturas de decisão if/else
        if( idade >= 18) {
          System.out.println( "Pode dirigir" );
        } else {
          System.out.println( "Não pode dirigir" );
        }

        // Ternário
        System.out.println(idade >= 18 ? "Pode dirigir" : "Não pode dirigir");
        
        // Estrutura de repetição for
        for (int i = 0; i <= idade; i ++) {
          System.out.println( "Idade: " + i );
        }

        /* Coleções List, MAP, Set
          List - Possui Index
          MAP - Possui chaves para identificar o valor
          Set - Não deixa os valores se repetirem
        */
        
        List<int> list = new ArrayList<int>();
        list.add(33);
    }
}