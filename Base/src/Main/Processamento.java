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

}
