public class CalculadoraJurosCompostosMeta {

    public static void main(String[] args) {
        double valorAcumulado = 10000;
        double valorMeta = 20000;
        double taxaJuros = 0.8;

        int mes = 1;

        while(valorAcumulado < valorMeta){
            System.out.println("Mês " + mes + " Valor acumulado: " + valorAcumulado);
            valorAcumulado += valorAcumulado * taxaJuros/100;
            mes++;

        }
        System.out.println("Meta Atingida no mês " + mes);

    }
}
