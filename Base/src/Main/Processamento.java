package Main;

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
        String r = "";
        char v[] = a.toCharArray();
        for(int i = 0; i < v.length; i++){
            if(v[i] == c1)
                r += c2;
            else
                r += v[i];
        }
        return r;
    }
    
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

}
