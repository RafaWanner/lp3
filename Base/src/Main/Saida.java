package Main;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Saida {
    
    public void imprimirNumeroDouble(double num, String msg) {

        DecimalFormat df = new DecimalFormat("###,##0.00");

        JOptionPane.showMessageDialog(null, msg + ": " + df.format(num));

    }

    public void imprimirAvisoString(String msg) {

        JOptionPane.showMessageDialog(null, msg);

    }

}
