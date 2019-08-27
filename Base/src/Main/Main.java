package Main;

public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        do {
            String a = entrada.lerString("Digite uma String");

            Processamento processamento = new Processamento();
            String r1 = processamento.getInitials(a);

            Saida saida = new Saida();
            saida.imprimirAvisoString(r1);
        } while (entrada.continuar("Executar novamente?"));
    }
}
