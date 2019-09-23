package Main;

import java.text.DecimalFormat;

public class Processamento {

    double delta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public Double getBaskharaP(double a, double b, double c) {
        double d = delta(a, b, c);
        if (d >= 0 && a != 0) {
            Double p = (-b + Math.sqrt(d)) / (2 * a);
            return p;
        } else {
            return null;
        }

    }

    public Double getBaskharaN(double a, double b, double c) {
        double d = delta(a, b, c);
        if (d >= 0 && a != 0) {
            Double p = (-b - Math.sqrt(d)) / (2 * a);
            return p;
        } else {
            return null;
        }

    }
    
    public String getInitials(String a) {
        String a1 = a.trim();
        String v [] = a1.split(" ");
        String r = "";
        for(int i = 0; i < v.length; i++){
            r += v[i].charAt(0) + " ";
        }
        return r;
    }
    
    public Integer getNumChar(String a, String b) {
    	int r = a.toLowerCase().split(b).length - 1;
    	return r;
    }
    
    public Integer getBlanks(String a) {
    	int r = a.split(" ").length - 1;
    	return r;
    }
    
    public int getWords(String a){
        int cont = 1;
        char v[] = a.trim().toCharArray();
        for(int i = 0; i < v.length; i++){
            if(v[i] == ' ' && v[i + 1] != ' ')
                cont++;
        }
        return cont;
    }
    
    public String changeChar(String a, char c1, char c2){
        String r = a.replace(c1, c2);
        return r;
    }
    
    /*
    public Double getFullNum(double a) {
    	String[] v1 = {"","um","dois","tres","quatro","cinco", "seis", "sete", "oito", "nove", "dez","onze","doze","treze","catorze","quinze","dezeseis","dezesete","dezoito","dezenove"};
    	String[] v2 = {"","dez","vinte","trinta","quarenta","cinquenta","sessenta","setenta","oitenta","noventa"};
    	String r = "";
    	DecimalFormat df = new DecimalFormat("###,##0.00");	
    	double a1 = Double.parseDouble(df.format(a));
    	return null;
    }
    */
    
    public int getUpperCase(String a){
        int cont = 0;
        char v[] = a.toCharArray();
        for(int i = 0; i < v.length; i++){
            if(Character.isUpperCase(v[i]))
                cont++;
        }
        return cont;
    }
    
    public int getLowerCase(String a){
        int cont = 0;
        char v[] = a.toCharArray();
        for(int i = 0; i < v.length; i++){
            if(Character.isLowerCase(v[i]))
                cont++;
        }
        return cont;
    }
    
    public int getVowels(String a){
        int cont = 0;
        char v[] = a.toLowerCase().toCharArray();
        for(int i = 0; i < v.length; i++){
            if(v[i] == 'a' || v[i] == 'e' || v[i] == 'i' || v[i] == 'o' || v[i] == 'u')
                cont++;
        }
        return cont;
    }
    
    public int getConsonants(String a){
        int cont = 0;
        char v[] = a.toLowerCase().toCharArray();
        for(int i = 0; i < v.length; i++){
            if(v[i] != 'a' && v[i] != 'e' && v[i] != 'i' && v[i] != 'o' && v[i] != 'u' && v[i] != ' ' && v[i] >= 'a' && v[i] <= 'z')
                cont++;
        }
        return cont;
    }
    
    public String getCharOrder(String a) {
    	String a1 = "";
    	char v[] = a.toLowerCase().toCharArray();
    	for(int i = 0; i < v.length-1; i++) {
    		for(int j = i+1; j < v.length; j++) {
    			if(v[i] >  v[j]) {
    				char temp = v[i];
        			v[i] = v[j];
        			v[j] = temp;	
    			}
    		}
    	}
    	for (int k = 0; k < v.length; k++) {
    		if(v[k] != ' ')
    			a1 += v[k];
    	}
    	return a1;
    }
    
    public double[][] getInMatrx(double[][] a){
    	for(int i = 0; i < a.length; i++) {
    		for(int j = 0; j < a.length; j++) {
    			
    		}
    	}
    	return null;
    }
}
