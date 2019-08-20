package Main;

public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        do {
            double a = entrada.lerNumeroDouble("A");
            double b = entrada.lerNumeroDouble("B");
            double c = entrada.lerNumeroDouble("C");

            Processamento processamento = new Processamento();
            Double r1 = processamento.getBaskharaP(a, b, c);
            Double r2 = processamento.getBaskharaN(a, b, c);

            Saida saida = new Saida();
            if (r1 != null && r2 != null) {
                saida.imprimirNumeroDouble(r1, "baskhara x1");
                saida.imprimirNumeroDouble(r2, "baskhara x2");
            } else {
                saida.imprimirAvisoString("Raiz negativa ou A igual a zero");
            }
        } while (entrada.continuar("Executar novamente?"));
    }
}
