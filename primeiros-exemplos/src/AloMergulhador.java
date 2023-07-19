import java.sql.SQLOutput;

public class AloMergulhador {

    public static void main(String[] args) {
        System.out.println("Olá Mergulhador");

        String nomeCompleto = "João da Silva";
        nomeCompleto = "José Sebastião";

        System.out.println("Nome: " + nomeCompleto);

        int minhaIdade = 50;

        int suaIdade = 40;

        int totalIdade = minhaIdade + suaIdade;

        System.out.println("Total:" + totalIdade);

        double peso = 98.9d;

        System.out.println(peso);

        float taxa = 1_294.98f;
        System.out.println(taxa);

        boolean compraAprovada = false;
        System.out.println(compraAprovada);

        boolean maiorDeIdade = minhaIdade == 50;
        System.out.println(maiorDeIdade);



    }
}
