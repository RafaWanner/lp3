package Main;

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
        	/* #5
        	String[] v = {"leia a ordem de uma matriz quadrada, seus elementos e imprima a matriz oposta da matriz lida", "leia a ordem de uma matriz, seus elementos e imprima a matriz transposta", "leia 2 matrizes de ordens iguais e verifique se as matrizes são iguais", "leia 2 matrizes de ordens iguais, some as duas matrizes e mostre o resultado", "leia 2 matrizes, faça a multiplicação delas e imprima o resultado"};
        	String a = entrada.lerEscolha("Escolha a operação", v);
        	if(a == "leia a ordem de uma matriz quadrada, seus elementos e imprima a matriz oposta da matriz lida") {
        		double[][] n1 = entrada.lerArray("Digite os numeros da matriz", 2);
        		double[][] r = processamento.getInMatrix(n1);
        		saida.printMatrix(r);
        	} else if(a == "leia a ordem de uma matriz, seus elementos e imprima a matriz transposta") {
        		double[][] n1 = entrada.lerArray("Digite os numeros da matriz", 1);
        		double[][] r = processamento.getTransMatrix(n1);
        		saida.printMatrix(r);
        	} else if(a == "leia 2 matrizes de ordens iguais e verifique se as matrizes são iguais") {
        		int o1 = entrada.lerInt("Digite a ordem 1 da matriz");
        		int o2 = entrada.lerInt("Digite a ordem 2 da matriz");
        		double[][] n1 = entrada.lerArrayEx("Digite os numeros da matriz", o1, o2);
        		double[][] n2 = entrada.lerArrayEx("Digite os numeros da matriz", o1, o2);
        		boolean r = processamento.getEqMatrix(n1, n2);
        		saida.printBoolean(r, "Resposta");
        	} else if(a == "leia 2 matrizes de ordens iguais, some as duas matrizes e mostre o resultado") {
        		int o1 = entrada.lerInt("Digite a ordem 1 da matriz");
        		int o2 = entrada.lerInt("Digite a ordem 2 da matriz");
        		double[][] n1 = entrada.lerArrayEx("Digite os numeros da matriz", o1, o2);
        		double[][] n2 = entrada.lerArrayEx("Digite os numeros da matriz", o1, o2);
        		double[][] r = processamento.getPlusMatrix(n1, n2);
        		saida.printMatrix(r);
        	} else if(a == "leia 2 matrizes, faça a multiplicação delas e imprima o resultado") {
        		int o11 = entrada.lerInt("Digite a ordem 1 da matriz 1");
        		int o12 = entrada.lerInt("Digite a ordem 2 da matriz 1");
        		int o21 = entrada.lerInt("Digite a ordem 1 da matriz 2");
        		double[][] n1 = entrada.lerArrayEx("Digite os numeros da matriz", o11, o12);
        		double[][] n2 = entrada.lerArrayEx("Digite os numeros da matriz", o21, o11);
        		double[][] r = processamento.getMultMatrix(n1, n2);
        		saida.printMatrix(r);
        	}
        	*/
        } while (entrada.continuar("Executar novamente?"));
    }
}
