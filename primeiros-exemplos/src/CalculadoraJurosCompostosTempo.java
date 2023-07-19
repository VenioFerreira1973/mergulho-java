public class CalculadoraJurosCompostosTempo {

    public static void main(String[] args) {

        double valorAcumulado = 10000;
        double taxaJuros = 0.8;
        int periodoMeses = 12;

        for(int i = 1; i <= periodoMeses; i++){
            System.out.println("Valor referente ao rendimento do mês " + i);
            valorAcumulado += valorAcumulado * taxaJuros/100;
            System.out.println("-> " + valorAcumulado);
        }
    }
}
