package Main;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        do {
        	/* #1
            String a = entrada.lerString("Digite uma String");
            char c1 = entrada.lerChar("Digite um Char");
            char c2 = entrada.lerChar("Digite um Char");
            int rb = processamento.getBlanks(a);
            int ra = processamento.getNumChar(a, "a");
            int re = processamento.getNumChar(a, "e");
            int ri = processamento.getNumChar(a, "i");
            int ro = processamento.getNumChar(a, "o");
            int ru = processamento.getNumChar(a, "u");
            int rw = processamento.getWords(a);
            String rc = processamento.changeChar(a,c1,c2);
            saida.printInt(rb, "Numero de Espaços");
            saida.printFiveInt(ra, re, ri, ro, ru, "Numero de Vogais (a, e, i, o, u)");
            saida.printInt(rw, "Numero de Palavras");
            saida.printString(rc);
            */
        	/* #3
        	String a = entrada.lerString("Digite uma String");
        	int rv = processamento.getVowels(a);
            int rc = processamento.getConsonants(a);
            int ru = processamento.getUpperCase(a);
            int rl = processamento.getLowerCase(a);
            saida.printInt(rv, "Numeor de Vogais");
            saida.printInt(rc, "Numeor de Consoantes");
            saida.printInt(ru, "Numeor de UpperCase");
            saida.printInt(rl, "Numeor de LowerCase");
        	*/
        	/* #4
        	String a = entrada.lerString("Digite uma String");
        	String r = processamento.getCharOrder(a);
        	saida.printString(r);
			*/
        	
        	String[] v = {"leia a ordem de uma matriz quadrada, seus elementos e imprima a matriz oposta da matriz lida", "leia a ordem de uma matriz, seus elementos e imprima a matriz transposta", "leia 2 matrizes de ordens iguais e verifique se as matrizes são iguais", "leia 2 matrizes de ordens iguais, some as duas matrizes e mostre o resultado", "leia 2 matrizes, faça a multimplicação delas e imprima o resultado"};
        	String a = entrada.lerEscolha("Escolha a operação", v);
        	if(a == "leia a ordem de uma matriz quadrada, seus elementos e imprima a matriz oposta da matriz lida") {
        		double[][] n = entrada.lerArray("Digite os numeros da matriz", 2);
        		JOptionPane.showMessageDialog(null, Arrays.toString(n));
        	}
        	
        } while (entrada.continuar("Executar novamente?"));
    }
}
