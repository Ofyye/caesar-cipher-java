import java .util.Scanner;
import java.text.Normalizer;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra:  ");
        String palavra = scanner.nextLine();

        palavra = Normalizer.normalize(palavra, Normalizer.Form.NFD);
        palavra = palavra.replaceAll("[^\\p{ASCII}]", "");

        System.out.print("Digite o valor do deslocamento: ");
        int deslocamento  = scanner.nextInt();

        System.out.println("Escolha uma opção:  ");
        System.out.println("1 - Criptografar");
        System.out.println("2 - Descriptografar");
        int opcao = scanner.nextInt();

        if (opcao ==2){
            deslocamento = -deslocamento;
        }

        String resultado = "";

        for (int i = 0; i < palavra.length(); i++){
            char letra = palavra.charAt(i);

            if (letra >= 'a' && letra <= 'z'){
                char novaLetra = (char) (letra + deslocamento);

                if (novaLetra > 'z'){
                    novaLetra = (char) (novaLetra - 26);
                }

                if (novaLetra < 'a'){
                    novaLetra = (char) (novaLetra + 26);
                }

                resultado = resultado + novaLetra;

            } else if (letra >= 'A' && letra <= 'Z') {
                char novaLetra = (char) (letra +deslocamento);

                if (novaLetra > 'Z'){
                    novaLetra = (char) (novaLetra -26);
                 }

                if (novaLetra < 'A'){
                    novaLetra = (char) (novaLetra + 26);
                }

                resultado = resultado + novaLetra;

             } else {
                resultado = resultado + letra;
            }
        }
        System.out.println("Resultado:   "+resultado);
    }
}
