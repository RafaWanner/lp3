package Main;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        do {
        	String a = entrada.lerString("Digite uma String");
        	int rv = processamento.getVowels(a);
            int rc = processamento.getConsonants(a);
            int ru = processamento.getUpperCase(a);
            int rl = processamento.getLowerCase(a);
            saida.printInt(rv, "Numeor de Vogais");
            saida.printInt(rc, "Numeor de Consoantes");
            saida.printInt(ru, "Numeor de UpperCase");
            saida.printInt(rl, "Numeor de LowerCase");
        } while (entrada.continuar("Executar novamente?"));
    }
}
