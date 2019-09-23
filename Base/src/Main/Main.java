package Main;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        do {
        	String a = entrada.lerString("Digite uma String");
        	String r = processamento.getCharOrder(a);
        	saida.printString(r);
        } while (entrada.continuar("Executar novamente?"));
    }
}
