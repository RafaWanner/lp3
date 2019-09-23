package Main;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        do {
        	double a = entrada.lerDoubleHL("Digite um double", -0.01, 100.0);
        	String r = processamento.getFullNum(a);
        	saida.printString(r);
        } while (entrada.continuar("Executar novamente?"));
    }
}
